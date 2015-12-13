package jebouquine.service.books.viewmodel;

public class SearchBookFormViewModel {
    private String ISBN;
    private String title;

    public SearchBookFormViewModel() {
    }

    public SearchBookFormViewModel(String ISBN, String title) {
        this.ISBN = ISBN;
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchBookFormViewModel that = (SearchBookFormViewModel) o;

        if (ISBN != null ? !ISBN.equals(that.ISBN) : that.ISBN != null)
            return false;
        return !(title != null ? !title.equals(that.title) : that.title != null);

    }

    @Override
    public int hashCode() {
        int result = ISBN != null ? ISBN.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public static SearchBookFormViewModel nullObject() {
        return new SearchBookFormViewModel("", "");
    }
}
