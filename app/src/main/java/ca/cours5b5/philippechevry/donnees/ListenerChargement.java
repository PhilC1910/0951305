package ca.cours5b5.philippechevry.donnees;

import java.util.Map;

public interface ListenerChargement {
    void reagirSucces(Map<String,Object> objecJson);
    void reagirErreur(Exception e);

}
