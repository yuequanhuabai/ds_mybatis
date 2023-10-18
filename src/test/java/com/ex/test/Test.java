package com.ex.test;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class Test {


//    1.rows cols 规定了数组的大小；
//
//    把输入的数值录入系统中
//
//    第一行输入的数值，分别传给rows和cols两个变量，这两个变量决定了数组范围的大小；
//
//    然后根据范围，把接下来的行数代码和列数值代码存入对应的数组中
//
//    然后才是处理数组中的数据，根据最后两个单元确定选中的范围；
//
//    在该返回内遍历数据，如果遇到公式格式，需要进行转换为数值；
//
//
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        int rows = scanner.nextInt();
//        int cols = scanner.nextInt();
//        scanner.nextLine();
//
//        String[][] values = new String[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            String line = scanner.nextLine();
//            String[] tokens = line.split(" ");
//            for (int j = 0; j < cols; j++) {
//                values[i][j] = tokens[j];
//            }
//        }
//
//        String selected = scanner.nextLine();
//        String[] range = selected.split(":");
//        int startRow = Integer.parseInt(range[0].substring(1)) - 1;
//        int startCol = range[0].charAt(0) - 'A';
//        int endRow = Integer.parseInt(range[1].substring(1)) - 1;
//        int endCol = range[1].charAt(0) - 'A';
//
//        int sum = 0;
//        for (int i = startRow; i <= endRow; i++) {
//            for (int j = startCol; j <= endCol; j++) {
//                String cell = values[i][j];
//                if (cell.startsWith("=")) {
//                    String formula = cell.substring(1);
//                    int value = evalFormula(formula, values);
//                    sum += value;
//                } else {
//                    int value = Integer.parseInt(cell);
//                    sum += value;
//                }
//            }
//        }
//        System.out.println(sum);
//
//    }
//
//    private static int evalFormula(String formula, String[][] values) {
//        Pattern pattern = Pattern.compile("[A-Z]\\d+");
//        Matcher matcher = pattern.matcher(formula);
//        StringBuffer sb = new StringBuffer();
//        while (matcher.find()) {
//            String ref = matcher.group();
//            int row = Integer.parseInt(ref.substring(1)) - 1;
//            int col = ref.charAt(0) - 'A';
//            String value = values[row][col];
//
//            if (value.startsWith("=")) {
//                value = Integer.toString(evalFormula(value.substring(1), values));
//            }
//
//            matcher.appendReplacement(sb, value);
//        }
//        matcher.appendTail(sb);
//        formula = sb.toString();
//
//        int result;
//        if (formula.contains("+")) {
//            String[] tokens = formula.split("\\+");
//            result = evalFormula(tokens[0], values) + evalFormula(tokens[1], values);
//        } else if (formula.contains("-")) {
//            String[] tokens = formula.split("-");
//            result = evalFormula(tokens[0], values) - evalFormula(tokens[1], values);
//        } else {
//            result = Integer.parseInt(formula);
//        }
//        return result;
//    }

}
