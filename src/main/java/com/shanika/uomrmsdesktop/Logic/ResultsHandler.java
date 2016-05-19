package com.shanika.uomrmsdesktop.Logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;

/**
 *
 * @author Shanika Ediriweera
 */
public class ResultsHandler {
    public String resultsFilePath = "results.xlsx";
    
    //add test
    //method to return ModuleGrade array
    public ModuleGrade[] setModuleGrades(Module module, String textBoxString){
        String[] textBoxArray = textBoxString.split(" ");
        String studentId, grade;
        
        int counter = 1;

        for(String textBoxElement : textBoxArray){
            //textBoxArray has both ids and grades
            if(counter%2 == 1){
                studentId = textBoxElement;
            }else{
                grade = textBoxElement;
                
                //creating Modulegrade object
                ModuleGrade moduleGrade = new ModuleGrade(student, module, grade)
            }
        }
        foreach ($arr as $element){
            //arr has both ids and grades
            if($counter%2 == 1){
                $stuId = $element;

            }else{
                $grd = $element;

                //getting stu_mod_grd using doctrine
                $stu_mod_grd = $doc->getRepository('AppBundle:student_module_grade')->findOneBy(array('mCode' => $module,'sId'=>$stuId));
                //create new stu_mod_grd if not found
                if($stu_mod_grd==null) 
                {
                    $stu_mod_grd = new student_module_grade();
                    $stu_mod_grd->setMCode($module);
                    
                    $stu_mod_grd->setSId($stuId);
                }
                //adding grade
                $stu_mod_grd->setGrade($grd);
                //die($stu_mod_grd->sId);
                $em->persist($stu_mod_grd);
                $em->flush();
            }
            $counter++;
        }
        return null;
    }
    
    //add test
    //method to get data from Excel sheet
    /**
     *
     * @param resultsFilePath
     * @return
     */
    public String getDataFromExcel(String resultsFilePath){
        String resultsString = "";
        FileInputStream file = null; 
        XSSFWorkbook workbook = null;
        XSSFSheet sheet = null;
        try {
            file = new FileInputStream(new File(resultsFilePath));
            
            //Create Workbook instance holding reference to .xlsx file
            workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            sheet = workbook.getSheetAt(0);
            
            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) 
            {
                Row row = rowIterator.next();
                //add cell value to the results string
                resultsString = resultsString + row.getCell(0).getStringCellValue()+" ";
                resultsString = resultsString + row.getCell(1).getStringCellValue()+"\n";
                
//                //For each row, iterate through all the columns
//                Iterator<Cell> cellIterator = row.cellIterator();
//                while (cellIterator.hasNext()) 
//                {
//                    Cell cell = cellIterator.next();
//                    //add cell value to the results string
//                    resultsString = resultsString + cell.getStringCellValue()+" ";
//                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ResultsHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ResultsHandler.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(file != null){
                try {
                    file.close();
                } catch (IOException ex) {
                    Logger.getLogger(ResultsHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(workbook != null){
                try {
                    workbook.close();
                } catch (IOException ex) {
                    Logger.getLogger(ResultsHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return resultsString;
    }
    
    
}
