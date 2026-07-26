package quiz.framework;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ConfiguracaoQuiz {
    Class<? extends PontuacaoStrategy> strategy();
    Class<?> fabric();
    Class<? extends QuizUI> ui();
}