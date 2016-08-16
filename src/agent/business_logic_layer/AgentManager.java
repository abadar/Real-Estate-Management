package agent.business_logic_layer;

import agent.data_access_layer.DAL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author arsalan
 */
public class AgentManager {

    private DAL dal;

    public AgentManager(DAL dal) {
        this.dal = dal;
    }

    /**
     * Function to update user password
     *
     * @param pass
     * @return
     */
    public boolean updatePassword(String pass) {
        boolean updated = false;
        String sql;
        try {
            sql = "UPDATE `agent` SET `password`='" + pass + "';";
            updated = dal.createStatement(sql);
        } catch (Exception ex) {
            Logger.getLogger(DataManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return updated;
    }
}
