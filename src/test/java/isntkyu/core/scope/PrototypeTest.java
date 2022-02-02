package isntkyu.core.scope;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class PrototypeTest {
    @Test
    void PrototypeBeanFind() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeTest.PrototypeBean.class);

        System.out.println("find1");
        PrototypeTest.PrototypeBean bean1 = ac.getBean(PrototypeTest.PrototypeBean.class);

        System.out.println("find2");
        PrototypeTest.PrototypeBean bean2 = ac.getBean(PrototypeTest.PrototypeBean.class);
        System.out.println("bean2 = " + bean2);
        System.out.println("bean1 = " + bean1);
        Assertions.assertThat(bean1).isNotSameAs(bean2);

        bean1.destroy(); //@PreDestroy 는 실행안됨
        ac.close();
    }

    @Scope("prototype")
    static class PrototypeBean {

        @PostConstruct
        public void init() {
            System.out.println("init");
        }

        @PreDestroy
        public void destroy(){
            System.out.println("destroy");
        }
    }
}
