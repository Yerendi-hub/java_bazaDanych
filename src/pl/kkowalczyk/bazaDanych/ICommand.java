package pl.kkowalczyk.bazaDanych;

public interface ICommand {
    String getName();
    String getDescription();
    String execute(String c);
}

