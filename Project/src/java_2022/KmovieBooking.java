package java_2022;

import java.io.*;
import java.util.*;
//수정
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import java.util.InputMismatchException;

class Person { 

	private String name; 

	public Person() {} //매개변수가 없는 생성자

	public void setName(String name){ //setter 함수
		this.name = name;
	}

	public String getName(){ //getter 함수
		return name;
	}

	public static void print(String name, int movieDate){ //static 메소드
		System.out.print(" ");
	}
}

class User extends Person implements Numbers {//상속, 인터페이스, 다형성
	public static void print(String name, int movieDate){ //메소드 오버라이딩
		System.out.println(name+"님 12월 "+movieDate+"일에 예매되었습니다.");
	}
	public void print(int a, int b){ //메소드 오버로딩, 다형성
		int num = calculate(a,b);
		System.out.println("예매일까지 "+num+"일 남았습니다.");
		System.out.println();
		System.out.println("프로그램이 10초 후에 종료됩니다.");
	}
	public int calculate(int number, int Date){ // 메소드 재정의
		return Date-number;
	}
}

interface Numbers { //인터페이스
	public int calculate(int number, int Date);
}

interface IsDate { //인터페이스
	public void isDate(int date);
}

class MyThread extends Thread{ //상속 스레드
	MyThread(){}
	@Override
	public void run() {
		for(int i = 10 ; i >= 1 ; i-- ) {
			System.out.println(i);
			try  {
				Thread.sleep(1000);
			} catch (Exception e){
				return;
			}
		}
		System.out.println("프로그램을 종료합니다.");
		System.out.println("감사합니다.");
	}
}

class MyThread2 implements Runnable{ //인터페이스 스레드
	MyThread2(){}
	@Override
	public void run() {
		System.out.println("감사합니다.");
		System.exit(0);
	}
}

public class KmovieBooking{ //메인함수
	public static void main(String[] args) {
		KmovieBooking st = new KmovieBooking();
		
		Scanner sc = new Scanner(System.in);

		System.out.println("영화추천 프로그램 MOVIE_LOVE 를 찾아주셔서 감사합니다.");
		System.out.println("현재 거주하고 계시는 국가를 선택해주세요");
		System.out.println("1.아시아/오세아니아 | 2.미주 | 3.유럽 | 4.중동 | 5.아프리카");
		int menu[] = new int[1]; //배열
		try { //예외처리
			menu[0] = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println();
			System.out.println("숫자가 아닙니다.");
			sc.nextLine();
		}
		if (menu[0] > 5){
			System.out.println();
			System.out.print("1 ~ 5 번중에 번호를 다시 입력해주세요 : ");
			try { //예외처리
				menu[0] = sc.nextInt();
				sc.nextLine();
			} catch (InputMismatchException e) {
				System.out.println();
				System.out.println("숫자가 아닙니다. 번호를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
				Runnable r = new MyThread2();
				Thread t = new Thread(r);
				t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception ex){
					return;
				}
			}
			if (menu[0] > 5){
				System.out.println();
				System.out.println("번호를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
				Runnable r = new MyThread2();
				Thread t = new Thread(r);
				t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception e){
					return;
				}
			}
		}
		
		Country country = null;
		
		switch(menu[0]){ //
			case 1:
				country = Country.Asia_or_Oceania; break;
			case 2:
				country = Country.Americas; break;
			case 3:
				country = Country.Europe; break;
			case 4:
				country = Country.MiddleEast; break;
			case 5:
				country = Country.Africa; break;	
		}
		System.out.println();
		System.out.println("현재"+ country +"에 거주하신다면 이와 같은 영화를 추천합니다.");
		
		if(country == Country.Asia_or_Oceania) {
			String word = "Asia_or_Oceania";
			st.printMovieList(word);
			st.check(word);
			st.reservation();
			
		}
		if(country == Country.Americas) {
			String word = "Americas";
			st.printMovieList(word);
			st.check(word);
			st.reservation();
		}
		if(country == Country.Europe) {
			String word = "Europe";
			st.printMovieList(word);
			st.check(word);
			st.reservation();
		}
		if(country == Country.MiddleEast) {
			String word = "MiddleEast";
			st.printMovieList(word);
			st.check(word);
			st.reservation();
		}
		if(country == Country.Africa) {
			String word = "Africa";
			st.printMovieList(word);
			st.check(word);
			st.reservation();
		}
	}
	
	public void check(String state) { //영화번호 확인
		System.out.println("이중에서 어떤 영화를 예매하시겠습니까? 영화의 번호를 입력해주세요.");
		Scanner scan = new Scanner(System.in);
		int select[] = new int[1];
		try { //예외처리
			select[0] = scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("숫자가 아닙니다.");
			scan.nextLine();
		}
		if (select[0] > 3){
			System.out.print("1 ~ 3 번중에 번호를 다시 입력해주세요 : ");
			try { //예외처리
				select[0] = scan.nextInt();
				scan.nextLine();
			} catch (InputMismatchException e) {
				System.out.println("숫자가 아닙니다. 번호를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
				Runnable r = new MyThread2();
				Thread t = new Thread(r);
				t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception ex){
					return;
				}
			}
			if (select[0] > 3){
				System.out.println("번호를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
				Runnable r = new MyThread2();
				Thread t = new Thread(r);
				t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception e){
					return;
				}
			}
		}
		chooseMovie(state,select[0]);
	}
	
	public void printMovieList(String nation) { //추천영화 목록 출력
		List<List<String>> movies = readCSV();
		 
        movies.remove(0); //첫줄 제거
        movies.stream()
                .filter(line->line.get(0).startsWith(nation))
                .map(line -> line.get(1))
                .forEach(System.out::println);
        System.out.println();
        return;
	}
	
	public void chooseMovie(String nation, int idx) { //파일 입/출력 & 컬렉션 프레임워크(List)
		List<List<String>> movies = readCSV();
		
        movies.remove(0); //첫줄 제거
        List<String> movieList = movies.stream()
                .filter(line->line.get(0).startsWith(nation))
                .map(line -> line.get(1))
                .collect(Collectors.toList());
        
        String result = movieList.get(idx-1);
        System.out.println();
        System.out.println(result + "을 예매하겠습니다.");
        System.out.println("예매 페이지로 넘어갑니다.");
        System.out.println();
        return;
	}
		
	public static List<List<String>> readCSV() {
        List<List<String>> csvList = new ArrayList<List<String>>();
        String filePath = "src/java_2022/kmovielist.csv";
        BufferedReader reader = null;
        String line = "";
 
        try { //예외처리
        	reader = new BufferedReader(new FileReader(filePath));
            while ((line = reader.readLine()) != null) { // readLine()은 파일에서 개행된 한 줄의 데이터를 읽어온다.
                List<String> tmpList = new ArrayList<String>();
                String[] lineArr = line.split(","); // 파일의 한 줄을 ,로 나누어 배열에 저장 후 리스트로 변환한다.
                tmpList = Arrays.asList(lineArr); // 배열을 리스트로 변환
                csvList.add(tmpList);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try { //예외처리
                if (reader != null) {
                    reader.close(); // 사용 후 BufferedReader를 닫아준다.
                }
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return csvList;
    }
	
	public void reservation() { //영화예매
		Scanner scanner = new Scanner(System.in);
		int today[] = new int[2]; //배
		System.out.print("오늘의 날짜를 입력해주세요(공백을 기준으로 월/일 순) : ");
		try { //예외처리
			today[0] = scanner.nextInt();
			today[1]= scanner.nextInt();           
		} catch (InputMismatchException e) {
			System.out.println("숫자가 아닙니다.");
			scanner.nextLine();
		}
		if (today[1] <= 0 || today[1] >= 31){
			System.out.print("1 ~ 31일 중에 날짜를 다시 입력해주세요(월/일 순) : ");
			try { //예외처리
				today[0] = scanner.nextInt();
				today[1]= scanner.nextInt();           
			} catch (InputMismatchException e) {
				System.out.println("숫자가 아닙니다. 날짜를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
				Runnable r = new MyThread2();
				Thread t = new Thread(r);
				t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception ex){
					return;
				}
			}
			if (today[1] <= 0 || today[1] >= 31){
				System.out.println("날짜를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
				Runnable r = new MyThread2();
				Thread t = new Thread(r);
				t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception e){
					return;
				}
			}
		}
		int num = today[1];
		int dates[] = new int[32]; //
		System.out.println("이름을 입력해주세요 : ");
		String name = scanner.next();

		User User = new User(); //객체생성
		User.setName(name);
		int movieDate[] = new int[1]; //
		System.out.print( num + " ~ 31일 중에 예매하실 날짜를 입력해주세요 : ");
		try { //예외처리
			movieDate[0] = scanner.nextInt();         
		} catch (InputMismatchException e) {
			System.out.println("숫자가 아닙니다.");
			scanner.nextLine();
		}
		if (movieDate[0] < num || movieDate[0] > 31){
			System.out.print( num + " ~ 31일 중에 예매하실 날짜를 다시 입력해주세요 : ");
			try { //예외처리
				movieDate[0] = scanner.nextInt();          
			} catch (InputMismatchException e) {
				System.out.println("숫자가 아닙니다. 날짜를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
				Runnable r = new MyThread2();
				Thread t = new Thread(r);
				t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception ex){
					return;
				}
			}
			if (movieDate[0] < num || movieDate[0] > 31){
				System.out.println("날짜를 두번 잘못입력하셨습니다. 프로그램을 종료합니다.");
				Runnable r = new MyThread2();
				Thread t = new Thread(r);
				t.start();
				try { //예외처리
					Thread.sleep(1000);
				} catch (Exception e){
					return;
				}
			}
		}
		Integer date1 = Integer.valueOf(dates[movieDate[0]]); //Wrapper객체 박싱
		int Date1 = date1.intValue(); //Wrapper 객체 언박싱
		if (Date1 == 0){
			String gName = User.getName();
			User.print(gName, movieDate[0]);
			User.print(num,movieDate[0]);
			MyThread th = new MyThread();
			th.start();
		}
		scanner.close();
	}
}
