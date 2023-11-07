package ma.yc.marjane.services;

public interface AuthentificationServiceAdmCtr<D> extends AuthentificationService<D> {
    boolean logout();
    D register(D d);
    D login(D d);
    boolean deleteAdminCentre(D d);
}
