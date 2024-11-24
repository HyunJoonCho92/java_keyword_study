package p2_memoryLeak_profiling;

import java.util.HashMap;
import java.util.Map;

public class problem1_memoryLeak {

    private static final Map<String, String> map = new HashMap<>();

    public static void main(String[] args) {
        // static Map에 데이터를 계속 적재한 상태로 프로그램 유지하면 메모리릭과 유사한 상황을 연출할 수 있습니다.
        // 프로그램을 작성해보시고, 실제로 heap 메모리가 어떻게 변화하는지 진행해보세요

        // private static final Map<String, String> map = new HashMap<>();
        // heap dump 그리고 visualVM을 사용하시면 힙 영역의 메모리를 확인하실 수 있습니다.
        // 또는 IDE(intellij)의 프로파일링 기능을 통해 확인하셔도 됩니다.

        // optional) 다른 메모리릭 사례가 어떤게 있을지 한번 고민해보시고요, 구글링이나 chatgpt의 도움을 받아 추가로 찾아보세요.

        try {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                String key = "key" + i;
                String value = "value" + i;

                map.put(key, value);

                if (i % 100_000 == 0) {
                    System.out.println("map 크기 : " + map.size());
                }
            }
        } catch (OutOfMemoryError e) {
            System.err.println("Out of Memory! Map size: " + map.size());
        }
        // 실행 결과 오류 발생
        // Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "main"
        // Exception: java.lang.OutOfMemoryError thrown from the UncaughtExceptionHandler in thread "JFR Periodic Tasks"


        // memory leak 사례
        // 1. Listener 미해제 -> listeners.clear()로 해결
        // 2. 스레드 풀에서 ThreadLocal 객체를 적절히 해제하지 않아 발생 -> threadLocal.remove()
        // 3. Static 필드에 객체를 참조할 경우 GC 불가능

    }
}
