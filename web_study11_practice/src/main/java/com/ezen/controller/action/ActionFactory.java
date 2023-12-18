package com.ezen.controller.action;

public class ActionFactory {

	private static ActionFactory instance = new ActionFactory();

	private ActionFactory() {
	}

	public static ActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;
		System.out.println("ActionFactory : " + command);

		if (command.equals("member_list")) {
			action = new MemberListAction();
		} else if (command.equals("member_update_form")) {
			action = new MemberUpdateFormAction();
		} else if (command.equals("member_update")) {
			action = new MemberUpdateAction();
		} else if (command.equals("member_update_form")) {
			action = new MemberListAction();
		} else if (command.equals("member_write-form")) {
			action = new MemberWriteFormAction();
		} else if (command.equals("member_write")) {
			action = new MemberWriteAction();
		} else if (command.equals("member_sales")) {
			action = new MemberSalesAction();
		} /*else if (command.equals("uploadSummernoteImageFile")) {
			action = new MemberSalesAction();
		}   */   
		return action;
	}

}
