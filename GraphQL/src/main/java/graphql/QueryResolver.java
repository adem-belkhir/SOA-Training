package graphql;

import business.ModuleBusiness;
import business.UniteEnseignementBusiness;
import com.coxautodev.graphql.tools.GraphQLRootResolver;
import entities.Module;
import entities.UniteEnseignement;

import java.util.ArrayList;
import java.util.List;

public class QueryResolver implements GraphQLRootResolver {

    private final UniteEnseignementBusiness ueHelper = new UniteEnseignementBusiness();
    private final ModuleBusiness moduleHelper = new ModuleBusiness();

    // ---------- Unites d'enseignement ----------
    public List<UniteEnseignement> allUEs() {
        return ueHelper.getListeUE();
    }

    public UniteEnseignement ueByCode(int code) {
        return ueHelper.getUEByCode(code);
    }

    public List<UniteEnseignement> uesByDomaine(String domaine) {
        return ueHelper.getUEByDomaine(domaine);
    }

    public List<UniteEnseignement> uesBySemestre(int semestre) {
        return ueHelper.getUEBySemestre(semestre);
    }

    // ---------- Modules ----------
    public List<Module> allModules() {
        return moduleHelper.getAllModules();
    }

    public Module moduleByMatricule(String matricule) {
        return moduleHelper.getModuleByMatricule(matricule);
    }

    public List<Module> modulesByType(Module.TypeModule type) {
        return moduleHelper.getModulesByType(type);
    }

    public List<Module> modulesByUE(int codeUE) {
        UniteEnseignement ue = ueHelper.getUEByCode(codeUE);
        if (ue == null) {
            return new ArrayList<>();
        }
        return moduleHelper.getModulesByUE(ue);
    }
}
