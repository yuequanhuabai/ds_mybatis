package com.ex.sm.m1.sta3;

public class SmallAction extends RealAction{



      public  void otherOperate( SmallAction smallAction){
          System.out.println("before operate");
          smallAction.operate(2,3);
          System.out.println("after operate");
      }

    @Override
    public int operate(int a, int b) {
        return super.operate(a, b);
    }
}
