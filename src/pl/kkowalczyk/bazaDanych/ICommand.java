package pl.kkowalczyk.bazaDanych;

public interface ICommand {
    String getName();
    String getDescription();
    String getDetailedDescription();
    String execute(String c);
}

