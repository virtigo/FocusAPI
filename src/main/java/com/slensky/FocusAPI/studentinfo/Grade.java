package com.slensky.FocusAPI.studentinfo;

public class Grade {
   
   public enum Type {
      GRADED,
      NOT_GRADED,
      PASS,
      FAIL,
      EXCUSED,
      ABSENT
   }
   
   private Double pointsReceived;
   private Double pointsMax;
   private Type gradeType;
   private final boolean isGraded;
   private final boolean isPassFail;
   
   
   public Grade(Type gradeType, double... gradeData) {
      
      this.gradeType = gradeType;
      
      boolean isGraded = false;
      boolean isPassFail = false;
      switch(gradeType) {
         case GRADED:
            this.pointsReceived = gradeData[0];
            this.pointsMax = gradeData[1];
            isGraded = true;
            break;
         case NOT_GRADED:
            this.pointsMax = gradeData[0];
            break;
         case PASS:
            isPassFail = true;
         case FAIL:
            isPassFail = true;
         case EXCUSED:
            this.pointsMax = gradeData[0];
            break;
         case ABSENT:
            this.pointsMax = gradeData[0];
            break;
      }
      
      this.isGraded = isGraded;
      this.isPassFail = isPassFail;
      
   }
   
   public String toString() {
      switch (gradeType) {
         case EXCUSED:
            return "Exc./" + getPointsMax();
         case PASS:
            return "Pass";
         case FAIL:
            return "Fail";
         case GRADED:
            return getPointsReceived() + "/" + getPointsMax() + " - " + Double.toString((getPointsReceived() / getPointsMax()) * 100) + "%";
         case NOT_GRADED:
            return "NG/" + getPointsMax();
         case ABSENT:
            return "ABS/" + getPointsMax();
      }
      //unreachable
      return null;
   }
   
   /* Accessors */
   public double getPointsReceived() {
      return pointsReceived;
   }
   public double getPointsMax() {
      return pointsMax;
   }
   public boolean isGraded() {
      return isGraded;
   }
   public boolean isPassFail() {
      return isPassFail;
   }
   public Type getGradeType() {
      return gradeType;
   }
   
}
