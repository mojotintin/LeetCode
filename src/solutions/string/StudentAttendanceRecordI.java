package solutions.string;

/**
 * Created by Calabash on 2017/4/16.
 * Problem Number : 551
 * Problem Name : Student Attendance Record I
 * Description : https://leetcode.com/problems/student-attendance-record-i/#/description
 * Difficulty : Easy
 * Tags : String
 */
public class StudentAttendanceRecordI {

  /**
   * Submission : 1
   * Status : Accepted
   * Runtime : 10ms
   */
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
      } else if (s.charAt(i) == 'L'){
        lConCount ++;
        if (lConCount > 2) {
          return false;
        }
      } else {
        lConCount = 0;
      }
    }
    return true;
  }
}
