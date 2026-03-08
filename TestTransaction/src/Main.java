import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import test12.Casher;
import test12.PercentageCoupon;
import test12.VolumeCoupon;
import test13.Student;
import test_12.Cube;
import test_12.Cylinder;
import test_12.Rectangle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Main {
    //接続用の情報をフィールドに定数として定義			
    private static String RDB_DRIVE="com.mysql.cj.jdbc.Driver";	//com.mysql.cj.jdbc.Driver		 com.mysql.jdbc.Driver
    private static String URL="jdbc:mysql://localhost/dev1";			
    private static String USER="root";			
    private static String PASSWD="123456";	
    
    
    public static int calculate(String expr) {
        int result = 0;
        int num = 0;
        char sign = '+'; // 默认第一个数是正数

        for (int i = 0; i < expr.length(); i++) {
            char c = expr.charAt(i);

            // 构造数字（支持多位数）
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // 遇到运算符或到达末尾
            if (c == '+' || c == '-' || i == expr.length() - 1) {
                if (sign == '+') {
                    result += num;
                } else if (sign == '-') {
                    result -= num;
                }
                sign = c;
                num = 0;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
    	//問題3
    	Scanner inputScanner =new Scanner(System.in);
    	System.out.println("input:");
    	String line = inputScanner.nextLine();	
    	
    	int res = calculate(line);
    	System.out.println("res:"+res);
    }
    
//	//問題1
//	Scanner inputScanner =new Scanner(System.in);
//	System.out.println("input 2 numbers:");
//	String line = inputScanner.nextLine();
//	String[] parts = line.split(" ");
//	if(parts.length == 2) {
//		int a = Integer.parseInt(parts[0]);
//		int b = Integer.parseInt(parts[1]);
//		System.out.println("sum is:"+ (int)(a+b));
//	}
//	
//	Pattern PATTERN = Pattern.compile("\\s*(\\d+)\\s*([+\\-*/])\\s*(\\d+)\\s*");
//	//問題2
//	Scanner inputScanner =new Scanner(System.in);
//	System.out.println("input:");
//	String line = inputScanner.nextLine();
//	Matcher matcher = PATTERN.matcher(line);
//    if (matcher.matches()) {
//        int left = Integer.parseInt(matcher.group(1));
//        char operator = matcher.group(2).charAt(0);
//        int right = Integer.parseInt(matcher.group(3));
//        
//        int res = 0;
//        int rem = 0;
//        switch (operator) {
//		case '+':
//			res = left+right;
//			break;
//		case '-':	
//			res = left-right;
//			break;
//		case '*':
//			res = left*right;
//			break;
//		case '/':
//			res = left/right;
//			rem = left%right;
//			break;
//		default:
//			break;
//		}
//        
//        System.out.println("res is:"+ res);
//        if(rem != 0) {
//        	System.out.println("rem is:"+ rem);
//        }
//    }
    
//    private static final Object LOCK = new Object();
//    private static boolean printNumber = true;
//    
//    public static void main(String[] args) {
//    	
//        Thread t1 = new Thread(() -> {
//            for (int i = 1; i <= 26; i++) {
//                synchronized (LOCK) {
//                    while (!printNumber) {
//                        try {
//                            LOCK.wait();
//                        } catch (InterruptedException e) {
//                            Thread.currentThread().interrupt();
//                        }
//                    }
//                    System.out.println(i);
//                    printNumber = false;
//                    LOCK.notify();
//                }
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (char c = 'A'; c <= 'Z'; c++) {
//                synchronized (LOCK) {
//                    while (printNumber) {
//                        try {
//                            LOCK.wait();
//                        } catch (InterruptedException e) {
//                            Thread.currentThread().interrupt();
//                        }
//                    }
//                    System.out.println(c);
//                    printNumber = true;
//                    LOCK.notify();
//                }
//            }
//        });
//
//        t1.start();
//        t2.start();
//    }
    
    
//	new Thread(new Runnable() {
//		
//		@Override
//		public void run() {
//			 for (int i = 1; i <= 52; i++) {
//		            System.out.println(i);
//		            try {
//						Thread.sleep(1);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//			 }
//		}
//	}).start();
//	
//	new Thread(new Runnable() {
//		
//		@Override
//		public void run() {
//            for (char c = 'A'; c <= 'Z'; c++) {
//                System.out.println(c);
//                try {
//					Thread.sleep(1);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//            }
//		}
//	}).start();
    
//  public static Map<String, String> readFileToMap(String filePath) {
//  Map<String, String> map = new HashMap<>();
//  try (BufferedReader reader = new BufferedReader(
//          new InputStreamReader(
//                  new FileInputStream(filePath),
//                  StandardCharsets.UTF_8))) {
//      String line;
//      while ((line = reader.readLine()) != null) {
//          // 去除首尾空白
//          line = line.trim();
//          if (line.isEmpty()) {
//              continue;
//          }
//          // 按空格分割成两部分
//          String[] parts = line.split("\\s+", 2);
//          if (parts.length == 2) {
//              map.put(parts[0], parts[1]);
//          }
//      }
//  } catch (IOException e) {
//      e.printStackTrace();
//  }
//  return map;
//}
////問題2
//String filePath = "C:\\Users\\doogi\\Downloads\\1.txt";
//
//Map<String, String> resultMap = readFileToMap(filePath);
//
//// 打印 HashMap 内容
//for (Map.Entry<String, String> entry : resultMap.entrySet()) {
//System.out.println(entry.getKey() + " -> " + entry.getValue());
//} 
    
    
//	//問題1
//	if(args.length == 2) {
//		String sourcePath = args[0];
//		String targetPath = args[1];
////        String sourcePath = "C:\\Users\\doogi\\Downloads\\CN115913939A.pdf";
////        String targetPath = "C:\\Users\\doogi\\Downloads\\CN115913939A4.pdf";
//
//        try (FileInputStream fis = new FileInputStream(sourcePath);
//             FileOutputStream fos = new FileOutputStream(targetPath)) {
//
//            byte[] buffer = new byte[1024]; // 1KB 缓冲区
//            int bytesRead;
//
//            while ((bytesRead = fis.read(buffer)) != -1) {
//                fos.write(buffer, 0, bytesRead);
//            }
//
//            System.out.println("文件复制完成");
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//	}else {
//		System.out.println("引数の数が足りません");
//	}
    
//	//問題1
//	if(args.length == 2) {
//		try {
//			int x = Integer.parseInt(args[0]);				
//            int y = Integer.parseInt(args[1]);				
//            System.out.println(x+y);
//		} catch (NumberFormatException e) {
//			System.out.println("引数はそれぞれ数値でなければいけません");
//		}
//		
//	}else {
//		System.out.println("引数の数が足りません");
//	}
    
    
//	//問題1
//	ArrayList<Integer> list =new ArrayList<Integer>();
//	Scanner inputScanner =new Scanner(System.in);
//	for (int i = 0; i < 5; i++) {
//		System.out.println("input:");
//    	int a = inputScanner.nextInt();
//    	list.add(a);
//	}
//	
//	Collections.sort(list);
//	for (Integer integer : list) {
//		System.out.println("list:" + integer);
//	}

//	//問題2
//	ArrayList<Integer> list2 =new ArrayList<Integer>();
//	list2.add(3);
//	list2.add(4);
//	list2.add(5);
//	list2.add(3);
//	
//	HashSet<Integer> set2 =new HashSet<Integer>(list2);
//
//	ArrayList<Integer> list3 = new ArrayList<Integer>(set2);
//	for (Integer integer : list3) {
//		System.out.println("list:" + integer);
//	}
	
//	//問題6
//	ArrayList<String> list =new ArrayList<String>();
//	for (int i = 0; i < 13; i++) {
//    	list.add("A"+(i+1));
//    	list.add("B"+(i+1));
//    	list.add("C"+(i+1));
//    	list.add("D"+(i+1));
//	}
//	list.add("X");
//	list.add("Y");
//	
//	ArrayList<String> list1 =new ArrayList<String>();
//	ArrayList<String> list2 =new ArrayList<String>();
//	ArrayList<String> list3 =new ArrayList<String>();
//	
//	//发牌
//	Random random = new Random();
//	int count = 54;
//	int index = 0;
//	for (int i = 0; i < 17; i++) {
//		index = random.nextInt(count);
//		list1.add(list.get(index));
//		list.remove(index);
//		count--;
//		
//		index = random.nextInt(count);
//		list2.add(list.get(index));
//		list.remove(index);
//		count--;
//		
//		index = random.nextInt(count);
//		list3.add(list.get(index));
//		list.remove(index);
//		count--;
//	}
//	
//	for (int i = 0; i < 17; i++) {
//		System.out.println("res1:"+ list1.get(i));
//		System.out.println("res2:"+ list2.get(i));
//		System.out.println("res3:"+ list3.get(i));
//	}
//	
//	for (String string : list) {
//		System.out.println("res:"+ string);
//	}    
    
    
//	// 問題1
//	Set<String> set =new HashSet<String>();
//	set.add("B");
//	set.add("A");
//	set.add("D");
//	set.add("C");
//	
//	ArrayList<String> list = new ArrayList<String>(set);
//	Collections.sort(list);
//	
//	for (String str : list) {
//		System.out.println("res:"+ str);
//	}
//	
//	// 問題2
//	ArrayList<String> list2 = new ArrayList<String>();
//	list2.add("1");
//	list2.add("2");
//	list2.add("3");
//	list2.add("2");
//	
//	Set<String> set2 =new HashSet<String>(list2);
//	ArrayList<String> list3 = new ArrayList<String>(set2);
//	
//	for (String string : list3) {
//		System.out.println("res:"+ string);
//	}
//	
//	// 問題3
//    // 1. 创建HashSet集合
//    HashSet<String> hs = new HashSet<>();
//    // 2. 添加数据到集合
//    hs.add("itcast");
//    hs.add("itheima");
//    hs.add("javase");
//    // 3. 迭代器遍历集合元素
//    Iterator<String> it = hs.iterator();
//    while(it.hasNext()){
//    	String str = it.next();
//        System.out.println(str); // 元素
//        System.out.println(str.length()); // 元素长度
//    }    
    
//    // 按年龄排序
//    class StudentComparator implements Comparator<Student> {
//        @Override
//        public int compare(Student s1, Student s2) {
//            return s2.getAge() - s1.getAge();
//        }
//    }
	
//	ArrayList<Student> list = new ArrayList<Student>();
//	Random random = new Random();
//	for (int i = 0; i < 20; i++) {
//		Student student = new Student();
//		student.setNumber(i+1);
//		int age = random.nextInt(3)+13;
//		int sex = random.nextInt(2);
//		int state = random.nextInt(3)+1;
//		int score = random.nextInt(50)+50;
//		student.setAge(age);
//		student.setScore(score);
//		student.setSex(sex==0?"male":"female");
//		student.setState(state);
//		list.add(student);
//	}
//	
//	for (Student student : list) {
//		System.out.println("res:"+ student.toString());
//	}
//	System.out.println("-------------------------------");
//	for (Student student : list) {
//		if(student.getState() == 3) {
//			System.out.println("res:"+ student.toString());
//		}
//	}
//	System.out.println("-------------------------------");
//	Collections.sort(list);
//	for (Student student : list) {
//		System.out.println("res:"+ student.toString());
//	}
//	
//	System.out.println("-------------------------------");
//	Collections.sort(list,new StudentComparator());
//	for (Student student : list) {
//		System.out.println("res:"+ student.toString());
//	}
    
    
    
    
//	Cube cube = new Cube(3, 4, 5);
//	double cuArea =  cube.getArea();
//	double cuVol = cube.getVolume();
//	
//	Cylinder cylinder = new Cylinder(3, 8);
//	double cyArea = cylinder.getArea();
//	double cyVol = cylinder.getVolume();
//	System.out.println("res cube :"+cuArea +" - "+cuVol);
//	System.out.println("res cylinder :"+cyArea +" - "+cyVol); 
    
//	Rectangle re = new Rectangle(3, 4);
//	double a = re.getArea();
//	double b = re.getPerimeter();
//	System.out.println("res:"+a +" - "+b);
    
//    private static void initGame() {
//    	System.out.println("initGame");
//    }
//    
//    private static void runGame() {
//    	System.out.println("runGame");
//    }
//    
//    private static void endGame() {
//    	System.out.println("endGame");
//    }
    
//        Transferable[] parts = {
//            new Switch(),
//            new Router()
//        };
//
//        for (Transferable work : parts) {
//            work.transfer();
//        }
    
//    	initGame();
//    	runGame();
//    	endGame();
    	
//        Clock clock = new Clock("10:30");
//        clock.showTime();
//
//        AlarmClock alarmClock = new AlarmClock("14:30");
//        alarmClock.showTime();
//        alarmClock.setAlarm("14:00");
//        alarmClock.alarm();
//        alarmClock.setAlarm("14:30");
//        alarmClock.alarm();

//        Employee taro = new Employee();
//        taro.name = "タロウ";
//        Manager hanako = new Manager();
//        hanako.name = "ハナコ";
//        
//        taro.operation();
//        hanako.operation();
//        hanako.management();
    	
//        Overloading o = new Overloading();
//        System.out.println(o.test());
//        o.test(1);
//        System.out.println(o.test(1,"test3"));
//        System.out.println(o.test("test4",1));

    	
//		Scanner input = new Scanner(System.in);	
//		System.out.println("身長を入力してください(cm):");
//		int a = input.nextInt();
//		System.out.println("体重を入力してください(kg):");
//		int b = input.nextInt();
//		double c = a/100f;
//		double d = b/(c*c);
//		DecimalFormat df = new DecimalFormat("#.##"); // 或者 "0.00"
//		df.setRoundingMode(RoundingMode.HALF_UP); // 设置四舍五入
//		String formattedNum = df.format(d);
//		System.out.println("あなたのBMIは"+formattedNum+"です。");
    	
//		Scanner input = new Scanner(System.in);	
//		System.out.println("整数1を入れてください:");
//		int a = input.nextInt();
//		System.out.println("整数2を入れてください:");
//		int b = input.nextInt();
//		System.out.println("整数3を入れてください:");
//		int c = input.nextInt();
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		list.add(a);
//		list.add(b);
//		list.add(c);
//		list.sort(Comparator.naturalOrder());
//		System.out.println("3つの整数値の最大は"+list.get(2)+"です。");
    	
//		Scanner input = new Scanner(System.in);	
//		System.out.println("整数を入れてください:");
//		int a = input.nextInt();
//		System.out.println(a+"を３乗すると"+(int)Math.pow(a, 3)+"です。");
    	
//		Scanner input = new Scanner(System.in);	
//		System.out.println("お名前を入力してください:");
//		String name = input.nextLine();
//		System.out.println("年齢をいれてください:");
//		String age = input.nextLine();
//		System.out.println(name+"("+age+")さん、こんにちは!");
    	
//    	//問題5
//		Scanner input = new Scanner(System.in);	
//		
//		System.out.println("input list count:");
//		int a = input.nextInt();
//		ArrayList<Integer> list =new ArrayList<Integer>();
//		for (int i = 0; i < a; i++) {
//			System.out.println("input number:");
//			int b = input.nextInt();
//			list.add(b);
//		}
//		
//		String array[][] = new String[9][a];
//		for (int i = 0; i < a; i++) {
//			int b = list.get(i);
//			for (int j = 0; j < 9; j++) {
//				if(j>=9-b) {
//					array[j][i] = "*";
//				}
//				else {
//					array[j][i] = " ";
//				}
//			}
//		}
//		
//		System.out.println("----------------------");
//		for (int j = 0; j < 9; j++) {
//			for (int i = 0; i < a; i++) {
//				System.out.print(array[j][i]+" ");
//			}
//			System.out.println();
//		}
//		for (int i = 0; i < a; i++) {
//			System.out.print(list.get(i)+" ");
//		}
//		
//		
//    	//問題1
//		Scanner input = new Scanner(System.in);	
//		
//		System.out.println("input list count:");
//		int a = input.nextInt();
//		ArrayList<Integer> list =new ArrayList<Integer>();
//		for (int i = 0; i < a; i++) {
//			System.out.println("input number:");
//			int b = input.nextInt();
//			list.add(b);
//		}
//		list.sort(Comparator.naturalOrder());
//		System.out.println("res:" + list.toString());
		
//    	ArrayList<Integer> list =new ArrayList<Integer>();
//		Scanner input = new Scanner(System.in);	
//		
//		for (int i = 0; i < 5; i++) {
//			System.out.println("input:");
//			int a = input.nextInt();
//			list.add(a);
//		}
//		
//		Collections.reverse(list);
//		
//		System.out.println("res:" + list.toString());
//    	
//        int[][] table = new int[9][9];
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                table[i][j] = (i + 1) * (j + 1);
//            }
//        }
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                System.out.printf("%2d ", table[i][j]);
//            }
//            System.out.println();
//        }
//    	
//		Scanner input = new Scanner(System.in);	
//		
//		System.out.println("input:");
//		int a = input.nextInt();
//		while(a != 0) {
//			
//			switch (a) {//Mon、Tue、Wed、Thu、Fri、Sat、Sun
//			case 1:
//				System.out.println("Mon");
//				break;
//			case 2:
//				System.out.println("Tue");
//				break;
//			case 3:
//				System.out.println("Wed");
//				break;
//			case 4:
//				System.out.println("Thu");
//				break;
//			case 5:
//				System.out.println("Fri");
//				break;
//			case 6:
//				System.out.println("Sat");
//				break;
//			case 7:
//				System.out.println("Sun");
//				break;
//			default:
//				break;
//			}
//			System.out.println("input:");
//			a = input.nextInt();
//		}
//		System.out.println("Over!");
		

    
    public static void testMysql() {
    	
        String  sql = null;			
        int     num = 0 ;			
		
        Connection con = null;			
        Statement  smt   = null;			
		
        try {			
                Class.forName(RDB_DRIVE);			
                con = DriverManager.getConnection(URL,USER,PASSWD);		
                
                con.setAutoCommit(false);
		
                smt = con.createStatement();			
		
                System.out.println("■登録SQL発行前の書籍一覧表示");			
                selectAll();			
		
                sql = "INSERT INTO bookinfo (isbn, title, price) values('00006', 'Object-C入門テキスト', 3500)";			
                num = smt.executeUpdate(sql);			
                System.out.println("\nSQL発行1回目：" + num + "件の新規レコードを登録しました。");			
		
                sql = "INSERT INTO bookinfo (isbn, title, price) values('00007', 'C++入門テキスト', 3000 )";			
                num = smt.executeUpdate(sql);			
                System.out.println("\nSQL発行2回目：" + num + "件の新規レコードを登録しました。");			
		
                System.out.println("\n■登録SQL発行後の書籍一覧表示");	
                
                con.commit();
                selectAll();			
		
        } catch (Exception e) {			
                System.out.println("JDBCデータベース接続エラー" + e);	
                try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
		
        } finally {			
                try {			
                        if (smt != null) {			
                                smt.close();			
                        }			
                        if (con != null) {			
                                con.close();			
                        }			
		
                } catch (SQLException ignore) {			
                        //例外処理の無視			
                }			
        }
    }
			
    private static void selectAll(){			
			
            Connection con = null;			
            Statement  smt = null;			
			
            try{			
                    Class.forName(RDB_DRIVE);			
                    con = DriverManager.getConnection(URL,USER,PASSWD);			
			
                    smt = con.createStatement();			
			
                    //データベースへ発行するSQL文			
                    String sql = "SELECT * FROM bookinfo";			
			
                    ResultSet rs = smt.executeQuery(sql);			
			
                    // 使用反射
                    Field[] fsFields = BookInfo.class.getFields();
                    while (rs.next()) {	
                    	for (int i = 0; i < fsFields.length; i++) {
                    		System.out.println( fsFields[i].getName() +" -> " + rs.getString(fsFields[i].getName()));
						}

//                            System.out.println("isbn -> "   + rs.getString("isbn") +			
//                                            "\t title -> " + rs.getString("title") +			
//                                            "\t price-> "  + rs.getString("price"));			
                    }			
			
            }catch (Exception e) {			
                    System.out.println("JDBCデータベース接続エラー");			
			
            }finally{			
                    try {			
                            if (smt != null) {			
                                    smt.close();			
                            }			
                            if (con != null) {			
                                    con.close();			
                            }			
			
                    } catch (SQLException ignore) {			
                            //例外処理の無視			
                    }			
            }			
    }			
}
