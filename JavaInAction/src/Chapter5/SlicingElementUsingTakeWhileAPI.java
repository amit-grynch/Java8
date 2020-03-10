
package Chapter5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import Chapter4.Dishes;
import Chapter4.TYPE;
import Chapter4.TetraFunction;

/**
 * @author amitg Drop/truncate the elements in stream using predicate With
 *         Filter, iterates all elements based condition given in predicate but
 *         with Slicing concepts, will stop iteration when conditions fails
 *         Slicing works with sorted Collection
 * 
 */
public class SlicingElementUsingTakeWhileAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TetraFunction<String, Integer, TYPE, Boolean, Dishes> dishes1 = (name, calories, type,
				isVegetrain) -> new Dishes(name, calories, type, isVegetrain);
		Dishes dishObj1 = dishes1.apply("pork", 800, TYPE.MEAT, false);

		TetraFunction<String, Integer, TYPE, Boolean, Dishes> dishes6 = (name, calories, type,
				isVegetrain) -> new Dishes(name, calories, type, isVegetrain);
		Dishes dishObj6 = dishes6.apply("season fruits", 120, TYPE.OTHERS, true);

		TetraFunction<String, Integer, TYPE, Boolean, Dishes> dishes2 = (name, calories, type,
				isVegetrain) -> new Dishes(name, calories, type, isVegetrain);
		Dishes dishObj2 = dishes2.apply("beef", 700, TYPE.MEAT, false);

		TetraFunction<String, Integer, TYPE, Boolean, Dishes> dishes3 = (name, calories, type,
				isVegetrain) -> new Dishes(name, calories, type, isVegetrain);
		Dishes dishObj3 = dishes3.apply("chicken", 400, TYPE.MEAT, false);

		TetraFunction<String, Integer, TYPE, Boolean, Dishes> dishes4 = (name, calories, type,
				isVegetrain) -> new Dishes(name, calories, type, isVegetrain);
		Dishes dishObj4 = dishes4.apply("french", 500, TYPE.OTHERS, true);

		TetraFunction<String, Integer, TYPE, Boolean, Dishes> dishes5 = (name, calories, type,
				isVegetrain) -> new Dishes(name, calories, type, isVegetrain);
		Dishes dishObj5 = dishes5.apply("rice", 350, TYPE.OTHERS, true);

		TetraFunction<String, Integer, TYPE, Boolean, Dishes> dishes7 = (name, calories, type,
				isVegetrain) -> new Dishes(name, calories, type, isVegetrain);
		Dishes dishObj7 = dishes7.apply("pizza", 550, TYPE.OTHERS, true);

		TetraFunction<String, Integer, TYPE, Boolean, Dishes> dishes8 = (name, calories, type,
				isVegetrain) -> new Dishes(name, calories, type, isVegetrain);
		Dishes dishObj8 = dishes8.apply("prawns", 300, TYPE.FISH, false);

		TetraFunction<String, Integer, TYPE, Boolean, Dishes> dishes9 = (name, calories, type,
				isVegetrain) -> new Dishes(name, calories, type, isVegetrain);
		Dishes dishObj9 = dishes9.apply("salmon", 450, TYPE.FISH, false);

		List<Dishes> dishesList = new ArrayList<Dishes>();
		dishesList.add(dishObj1);
		dishesList.add(dishObj6);
		dishesList.add(dishObj2);
		dishesList.add(dishObj3);
		dishesList.add(dishObj4);
		dishesList.add(dishObj5);
		dishesList.add(dishObj7);
		dishesList.add(dishObj8);
		dishesList.add(dishObj9);

		// Slicing the element based on calories
		Stream<Dishes> dishStream = dishesList.stream().dropWhile(dishes -> dishes.getCalories() > 200);
		dishStream.forEach(System.out::println);

	}

}
