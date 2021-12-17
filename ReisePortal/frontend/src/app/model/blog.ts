export class Blog {
  constructor(public blogId: number,
              public blogTitle: string,
              public blogText: string,
              public blogDate: string,
              public blogNumberOfViews: number,
              public authorId: number,
              public locationId: number) {
  }
}

