package cn.cty;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 
 * 工具类 对象深度克隆
 * 
 * @author hlyton
 *
 */
public class ObjDeepClone {

	/**
	 * 对象深度克隆
	 * 
	 * @author hlyton
	 * @date 2017-10-15 23:12
	 * 
	 * @param obj
	 * @return
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	public static <T> T deepClone(T obj) {

		if (obj != null && obj instanceof Serializable) {

			T returnObj = null;

			try {

				ByteArrayOutputStream baos = new ByteArrayOutputStream();

				ObjectOutputStream oos = new ObjectOutputStream(baos);
				oos.writeObject(obj);

				ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
				ObjectInputStream ois = new ObjectInputStream(bais);

				return returnObj = (T) ois.readObject();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return null;
	}

	
	/*
	public static void main(String[] args) {

		Address add1 = new Address("1111addr");
		Address add2 = new Address("2222addr");

		People p1 = new People("douglas", 12, add1);

		People p2 = ObjDeepClone.deepClone(p1);
		p2.setAge(18);
		p2.setAddress(add2);

		System.out.println(p1.getAge());
		System.out.println(p2.getAge());
		System.out.println(p1.getAddress().getName());
		System.out.println(p2.getAddress().getName());
		System.out.println();
		System.out.println();

	}*/

}


/*
class Address implements Serializable {

	
	private static final long serialVersionUID = -7868747122044247754L;
	private String name;

	public Address(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}


class People implements Serializable {

	private static final long serialVersionUID = -2144690575830195687L;

	String name;

	Integer age;

	Address address;

	public People(String name, Integer age, Address address) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
*/




