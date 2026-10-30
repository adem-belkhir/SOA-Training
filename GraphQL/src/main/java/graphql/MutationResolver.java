package graphql;

import business.ModuleBusiness;
import business.UniteEnseignementBusiness;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;

public class MutationResolver implements GraphQLRootResolver {

    private final UniteEnseignementBusiness ueHelper = new UniteEnseignementBusiness();
    private final ModuleBusiness moduleHelper = new ModuleBusiness();

    // ---------- Unites d'enseignement ----------
    public boolean addUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre) {
        if (ueHelper.getUEByCode(code) != null) {
            return false; // code deja utilise
        }
        return ueHelper.addUniteEnseignement(new UniteEnseignement(code, domaine, responsable, credits, semestre));
    }

    public boolean updateUniteEnseignement(int code, String domaine, String responsable, int credits, int semestre) {
        return ueHelper.updateUniteEnseignement(code,
                new UniteEnseignement(code, domaine, responsable, credits, semestre));
    }

    public boolean deleteUniteEnseignement(int code) {
        return ueHelper.deleteUniteEnseignement(code);
    }

    // ---------- Modules ----------
    public boolean addModule(String matricule, String nom, int coefficient, int volumeHoraire,
                             Module.TypeModule type, int codeUE) {
        UniteEnseignement ue = ueHelper.getUEByCode(codeUE);
        if (ue == null || moduleHelper.getModuleByMatricule(matricule) != null) {
            return false; // UE inexistante ou matricule deja utilise
        }
        return moduleHelper.addModule(new Module(matricule, nom, coefficient, volumeHoraire, type, ue));
    }

    public boolean updateModule(String matricule, String nom, int coefficient, int volumeHoraire,
                                Module.TypeModule type, int codeUE) {
        UniteEnseignement ue = ueHelper.getUEByCode(codeUE);
        if (ue == null) {
            return false;
        }
        return moduleHelper.updateModule(matricule,
                new Module(matricule, nom, coefficient, volumeHoraire, type, ue));
    }

    public boolean deleteModule(String matricule) {
        return moduleHelper.deleteModule(matricule);
    }
}
