package xpto.exception.notFound;

public class CompanyNotFoundException extends RuntimeException {

    public CompanyNotFoundException(int id) {
        super(String.format("Company with id %d not found.", id));
    }
}
