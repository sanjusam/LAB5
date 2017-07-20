package cs.cs430.lab5;


import java.sql.ResultSet;
import java.util.Random;

//CREATE TABLE member (
//        memberID        INT           NOT NULL,
//        first_name      VARCHAR(25)   NOT NULL,
//        last_name       VARCHAR(25)   NOT NULL,
//        DOB             date          NOT NULL,
//        gender          VARCHAR(10)   NOT NULL,
//        PRIMARY KEY (memberID)
//        );
public class MemberDetails {

    public boolean memberExists(final String memberId) {
        final String getMemberSql = "select 1 from member where memberID = " + memberId;
        ResultSet resultSet = Lab5Utils.executeSelect(getMemberSql);
        return Lab5Utils.checkIRecordFound(resultSet);
    }

    public int addMember(final String memberFirstName, final String memberLastName, final String dateOfBirth,
                              final String gender) {
        final int newMemId = getNextMemberId();
        //(1100,'Bugs','Bunny',STR_TO_DATE('6/24/1990','%m/%d/%Y'), "M"),
        final String addMemberSql = "insert into member (memberID, first_name, last_name, DOB,gender) "
                + "values "
                + " ( " + newMemId + ","
                + memberFirstName  + ","
                + memberLastName   + ","
                + "STR_TO_DATE('" + dateOfBirth +"','%m/%d/%Y')" + ","
                + gender
                + ")";

        final int ret  = Lab5Utils.updateOrInsertDatabase(addMemberSql);
        if (ret != Lab5Utils.FAILURE) {
            return newMemId;
        } else  {
            return Lab5Utils.FAILURE;
        }
    }

    private int getNextMemberId() {
        final String getMaxMemberID = "select max(memberID) as maxMemberId from member";
        ResultSet resultSet = Lab5Utils.executeSelect(getMaxMemberID);
        final int maxValue = Lab5Utils.getColumnAsInt(resultSet, "maxMemberId");
        if(maxValue != Lab5Utils.FAILURE) {
            return maxValue + 1;
        } else {
            Lab5Utils.logMessage("Unable to generate member ID, max returned from DB is " + maxValue);
            Random rand = new Random();
            return rand.nextInt(5000) + 1;
        }
    }
}
