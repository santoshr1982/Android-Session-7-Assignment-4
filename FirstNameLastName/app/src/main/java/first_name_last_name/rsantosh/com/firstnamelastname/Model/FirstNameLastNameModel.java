package first_name_last_name.rsantosh.com.firstnamelastname.Model;

/**
 * Created by C S Ramachandran on 16-06-2016.
 */
public class FirstNameLastNameModel {

    public int strId;
    public String strFName;
    public String strLName;

    public FirstNameLastNameModel(String strLName, String strFName, int strId) {
        this.strLName = strLName;
        this.strFName = strFName;
        this.strId = strId;
    }

    public int getStrId() {
        return strId;
    }

    public void setStrId(int strId) {
        this.strId = strId;
    }

    public String getStrFName() {
        return strFName;
    }

    public void setStrFName(String strFName) {
        this.strFName = strFName;
    }

    public String getStrLName() {
        return strLName;
    }

    public void setStrLName(String strLName) {
        this.strLName = strLName;
    }
}
