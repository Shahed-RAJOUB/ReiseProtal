import {LocationStat} from "./location-stat";

export class BlogStats {
  constructor(public monthly: LocationStat[],
              public allTime: LocationStat[]) {
  }
}
