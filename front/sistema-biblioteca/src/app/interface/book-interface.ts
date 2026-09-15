export interface BookInterface {
  id?: string;
  title: string;
  authors: string;
  pages: number;
  releaseYear: Date | string;
  description: string;
}
