package TemplateMethod;

//炒蒜蓉菜心的类
public class ConcreteClass_CaiXin extends  AbstractClass{
        public void  pourVegetable(){
            System.out.println("下锅的蔬菜是菜心");
        }
        public void  pourSauce(){
            System.out.println("下锅的酱料是蒜蓉");
        }
}
