package jebouquine.service.books.viewmodel;

public class SearchBookFormViewModel {
    private String value;
    private String criteria;
    private static final String criteriaISBN = "ISBN";
    private static final String criteriaTitle = "title";

    public SearchBookFormViewModel() {
    }

    public SearchBookFormViewModel(String criteria, String value) {
        this.criteria = criteria;
        this.value = value;
    }

    public static String getCriteriaISBN() {
        return criteriaISBN;
    }

    public static String getCriteriaTitle() {
        return criteriaTitle;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchBookFormViewModel that = (SearchBookFormViewModel) o;

        if (value != null ? !value.equals(that.value) : that.value != null)
            return false;
        return !(criteria != null ? !criteria.equals(that.criteria) : that.criteria != null);

    }

    @Override
    public int hashCode() {
        int result = value != null ? value.hashCode() : 0;
        result = 31 * result + (criteria != null ? criteria.hashCode() : 0);
        return result;
    }

    public static SearchBookFormViewModel nullObject() {
        return new SearchBookFormViewModel(criteriaISBN, "");
    }

    public String getISBN() {
        assert criteria.equals(criteriaISBN);
        return value;
    }
}
