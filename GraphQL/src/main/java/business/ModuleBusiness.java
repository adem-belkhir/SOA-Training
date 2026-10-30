package business;

import entities.Module;
import entities.UniteEnseignement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModuleBusiness {
    private static final List<Module> modules = new ArrayList<>();

    // Seed data is loaded ONCE
    static {
        UniteEnseignementBusiness ueBusiness = new UniteEnseignementBusiness();
        modules.add(new Module("M101", "Algorithmique", 3, 30, Module.TypeModule.PROFESSIONNEL, ueBusiness.getUEByCode(1)));
        modules.add(new Module("M102", "Base de données", 2, 20, Module.TypeModule.PROFESSIONNEL, ueBusiness.getUEByCode(1)));
        modules.add(new Module("M201", "Communication", 1, 15, Module.TypeModule.TRANSVERSAL, ueBusiness.getUEByCode(2)));
    }

    private final UniteEnseignementBusiness uniteEnseignementBusiness = new UniteEnseignementBusiness();

    public ModuleBusiness() { }

    public boolean addModule(Module module) {
        if (module.getUniteEnseignement() == null) return false;
        UniteEnseignement ue = uniteEnseignementBusiness.getUEByCode(module.getUniteEnseignement().getCode());
        if (ue != null) {
            module.setUniteEnseignement(ue);
            return modules.add(module);
        }
        return false;
    }

    public Module getModuleByMatricule(String matricule) {
        for (Module m : modules) {
            if (m.getMatricule().equals(matricule)) return m;
        }
        return null;
    }

    public List<Module> getModulesByType(Module.TypeModule type) {
        List<Module> result = new ArrayList<>();
        for (Module m : modules) {
            if (m.getType() == type) result.add(m);
        }
        return result;
    }

    public boolean updateModule(String matricule, Module updatedModule) {
        for (int i = 0; i < modules.size(); i++) {
            if (modules.get(i).getMatricule().equals(matricule)) {
                modules.set(i, updatedModule);
                return true;
            }
        }
        return false;
    }

    public boolean deleteModule(String matricule) {
        Iterator<Module> iterator = modules.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getMatricule().equals(matricule)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Module> getAllModules() {
        return modules;
    }

    public List<Module> getModulesByUE(UniteEnseignement ue) {
        List<Module> result = new ArrayList<>();
        for (Module m : modules) {
            if (m.getUniteEnseignement() != null && m.getUniteEnseignement().getCode() == ue.getCode()) {
                result.add(m);
            }
        }
        return result;
    }
}
