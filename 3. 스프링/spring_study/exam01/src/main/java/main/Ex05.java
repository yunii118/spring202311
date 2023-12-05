package main;

public class Ex05 {
    public static void main(String[] args) {
        // exception 클래스들은 생성자만 가지고있음.
        // 메서드 확인 및 자세한 사항 보고싶으면 trowable 확인
        //ArthmeticException - RuntimeException
        // class파일 생성 됨. 실행 중 체크가 됨. 컴파일은 가능
        // 예외처리 목적 ? 서빅스 중단을 막기 위한
        // try ~ catch

       try{
            int num1 = 10;
            int num2 = 0;
            int result = num1/num2; // throw new  ArithmethicException(); 던질수 있어야지만 예외 발생
        }catch(ArithmeticException e){ // = new ArithmethicException()을 catch
           e.printStackTrace();
           System.out.println("예외 처리");
        }
       // 예외처리 하지 않는다면 이 코드가 실행되지 않음
        System.out.println("중요한 실행코드");


    }
}
