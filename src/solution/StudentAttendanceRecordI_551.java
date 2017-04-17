package solution;

/**
 * Created by Calabash on 2017/4/16.
 *
 */
public class StudentAttendanceRecordI_551 {

    public boolean checkRecord(String s) {
        int aCount = 0;
        int lConCount = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == 'A'){
                aCount ++;
                lConCount = 0;
                if (aCount > 1) {
                    return false;
                }
            }else if (s.charAt(i) == 'L'){
                lConCount ++;
                if (lConCount > 2) {
                    return false;
                }
            }
            else lConCount = 0;
        }
        return true;
    }
}
