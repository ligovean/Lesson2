package enumtask;

public class DayOfWeekMain {

    public static void main(final String[] args) {

        System.out.println(getWorkingHours(DayOfWeek.MONDAY)); //Пример из задания
        System.out.println();
        System.out.println("=============/Вывод всех дней недели/=============");
        for (DayOfWeek d: DayOfWeek.values()){
            System.out.printf("Сейчас %s. %s \n",d.getName(),getWorkingHours(d));
        }
    }

    public static String getWorkingHours(DayOfWeek d){
        //В ходе обсуждения с заказчиком выяснилось,
        // что он хочет текстовый вывод в формате
        // "Осталось n ч. до конца рабочей недели!"

        if (d.getHoursQty()==0)
            return "Выходной день!";
        return "Осталось " + Integer.toString(d.getHoursQty()) + " ч. до конца рабочей недели!";
    }
}