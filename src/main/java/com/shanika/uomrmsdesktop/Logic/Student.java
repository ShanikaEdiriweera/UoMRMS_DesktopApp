package com.shanika.uomrmsdesktop.Logic;

/**
 *
 * @author Shanika Ediriweera
 */
public class Student extends User{
    private double cGPA;
    private int rank;
    //havent created an entity for batch
    private int batch;
    private String userId;

    public Student(){
        
    }
    public Student(String ID, String username, String password,String name, Gender gender, UserType userType, Department department, int batch,String state) {
        super(ID, username,password,name, gender, userType, department,state);
        cGPA = 0.0;
        rank = 0;
        this.batch = batch; 
    }
    
//    public static Student getStudent(String ID){
//        $student = new Student();
//        $stmt = $con->prepare('SELECT id,name,index_no,CGPA,rank FROM student WHERE id=?');
//        $stmt->bind_param("s",$id);
//        $stmt->execute();
//
//        $stmt->bind_result($student->id,$student->name,$student->indexNo,$student->cGPA,$student->rank);
//        $stmt->fetch();
//        $stmt->close();
//        return $student;
//    }

    public double getcGPA() {
        return cGPA;
    }

    public void setcGPA(double cGPA) {
        this.cGPA = cGPA;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getBatch() {
        return batch;
    }

    public void setBatch(int batch) {
        this.batch = batch;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
    
    
}
