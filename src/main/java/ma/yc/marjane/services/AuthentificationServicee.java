package ma.yc.marjane.services;

public interface AuthentificationServicee<D> extends AuthentificationService<D>{
//    D login(D D) throws CustomException;
    boolean logout();
    D register(D d);
    D login(D d);

}
