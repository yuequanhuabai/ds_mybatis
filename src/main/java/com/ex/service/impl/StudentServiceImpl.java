package com.ex.service.impl;

import com.ex.dao.StudentDao;
import com.ex.entity.Student;
import com.ex.service.StudentService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentDao studentDao;

    @Override
    public List<Student> queryStus(String name, Integer pageSize, Integer pageNum) {
        List<Student> students = studentDao.queryStus();
        return students;
    }


    @Override
    public Integer insertStudent(Student student) {
        Integer integer = studentDao.insertStu(student);
        return integer;
    }
    @Override
    public void getExcel() {
        List<Student> students = studentDao.queryStus();
        int size = students.size();

        Workbook workbook;
        workbook= new HSSFWorkbook();
        Sheet mySheet1 = workbook.createSheet("MySheet1");
        mySheet1.autoSizeColumn(1);
        Row row1 = mySheet1.createRow(0);
        Cell cell = row1.createCell(0, CellType.STRING);
        cell.setCellValue("ID");
//        cell.setCellStyle(new HSSFCellStyle());
//        cell.setCellStyle(Font.);
        Cell cell3 = row1.createCell(1, CellType.STRING);
        cell3.setCellValue("姓名");

        for(int i=1;i<=size;i++){
            Row row = mySheet1.createRow(i);
            Student student = students.get(i-1);

            Cell   cell1 = row.createCell(0, CellType.STRING);
            cell1.setCellValue(student.getId());
            Cell cell2=row.createCell(1,CellType.STRING);
            cell2.setCellValue(student.getName());

        }

        OutputStream os=null;
        try {
            os = new FileOutputStream("a.xls");
            workbook.write(os);
            os.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}
