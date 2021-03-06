package org.salem.service;

import java.util.ArrayList;
import java.util.List;

import org.salem.domain.Todo;

public class TodoService {
	
	private static int sequence = 0;
	private static List<Todo> todoList = new ArrayList<>();
	
	//맨 처음 한번만 실행시키고 싶을때
	static {
		for(int i = 0; i < 10; i++) {
			Todo todo = new Todo();
			todo.setTitle("하고 싶은 말" + i);
			todo.setPk(++sequence);
			todoList.add(todo);
		}
	}
	
	public TodoService() {
		
	}
	
	public boolean modify(Todo target) {
		
		int idx = todoList.indexOf(target);
		
		if(idx == -1) { return false;}
		
		todoList.get(idx).setTitle(target.getTitle());
		
		return true;
	}
	
	public boolean delete(Integer pk) {
		Todo target = new Todo();
		target.setPk(pk);
		
		return todoList.remove(target);
	}
	
	public List<Todo> getAll(){
		return todoList;
	}
	
	public int add(Todo todo) {
		todo.setPk(++sequence);
		todoList.add(todo);
		return todo.getPk();
	}
	
}
