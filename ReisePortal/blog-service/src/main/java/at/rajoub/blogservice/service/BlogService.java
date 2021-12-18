package at.rajoub.blogservice.service;

import at.rajoub.blogservice.client.AuthorServiceClient;
import at.rajoub.blogservice.client.LocationServiceClient;
import at.rajoub.blogservice.entity.Blog;
import at.rajoub.blogservice.model.Author;
import at.rajoub.blogservice.model.BlogEntry;
import at.rajoub.blogservice.model.Location;
import at.rajoub.blogservice.model.LocationStat;
import at.rajoub.blogservice.model.LocationStats;
import at.rajoub.blogservice.model.ViewMessage;
import at.rajoub.blogservice.repository.BlogRepository;
import at.rajoub.blogservice.service.kafka.KafkaService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.cloud.sleuth.annotation.SpanTag;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogService {

    private final BlogRepository blogRepository;
    private final AuthorServiceClient authorServiceClient;
    private final LocationServiceClient locationServiceClient;
    private final KafkaService kafkaService;

    public void saveBlogEntry(Blog blog) {
        blogRepository.save(blog.toBuilder()
                .blogDate(LocalDate.now())
                .build());
    }

    @NewSpan
    public Optional<BlogEntry> getBlogWithId(@SpanTag(key = "blogId") long blogId) {
        Optional<Blog> blog = blogRepository.findById(blogId);
        if (blog.isEmpty()) {
            return Optional.empty();
        }

        Author author = authorServiceClient.findAuthorById(blog.orElseThrow().getAuthorId());
        Location location = locationServiceClient.findLocationById(blog.orElseThrow().getLocationId());

        kafkaService.sendMessage(ViewMessage.builder()
                .blogId(blogId)
                .build());

        return Optional.of(BlogEntry.builder()
                .blog(blog.orElseThrow())
                .author(author)
                .location(location)
                .build());
    }

    public List<BlogEntry> getBlogs() {
        return blogRepository.findAll()
                .stream()
                .map(blog -> {
                    Author author = authorServiceClient.findAuthorById(blog.getAuthorId());
                    Location location = locationServiceClient.findLocationById(blog.getLocationId());
                    return BlogEntry.builder()
                            .blog(blog)
                            .author(author)
                            .location(location)
                            .build();
                })
                .collect(Collectors.toList());
    }

    public LocationStats getLocationStats() {
        List<Location> locations = locationServiceClient.selectAllLocations();
        List<LocationStat> allTime = blogRepository.findAllTimeLocationStats();
        List<LocationStat> monthly = blogRepository.findCurrentMonthLocationStats(LocalDate.now().getYear(), LocalDate.now().getMonthValue());

        return LocationStats.builder()
                .allTime(locations.stream()
                        .map(location -> allTime.stream().filter(it -> it.getLocationId().equals(location.getLocationId())).findFirst()
                                .map(it -> it.toBuilder().name(location.getLocationName()).build())
                                .orElseGet(() -> LocationStat.builder().name(location.getLocationName()).count(0).build()))
                        .collect(Collectors.toList()))
                .monthly(locations.stream()
                        .map(location -> monthly.stream().filter(it -> it.getLocationId().equals(location.getLocationId())).findFirst()
                                .map(it -> it.toBuilder().name(location.getLocationName()).build())
                                .orElseGet(() -> LocationStat.builder().name(location.getLocationName()).count(0).build()))
                        .collect(Collectors.toList()))
                .build();
    }
}
