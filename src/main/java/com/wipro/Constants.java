package com.wipro;

import com.wipro.model.Question;

public interface Constants {
	
	public static Question springQuestionAndAnswerOption[] ={			
			new Question(1L, "What is spring?", new String[] { "J2EE App Server", "J2EE App Development Framework", "Configuration Management Tool", "Build Tool" }, 2),
			new Question(2L, "What is the full form of IOC?", new String[] { "Inversion Of Control", "Interjection Of Control", "Internal Object Control", "In-built Object Control" }, 1),
			new Question(3L, "What is the full form of AOP?", new String[] { "Anticipation of Properties", "Aspect Oriented Programming", "Associated Object Programming", "Anti Object Programming" }, 2),
			new Question(4L, "Which of the below is a spring container?", new String[] { "View Resolver", "Application Context", "Handler Mapping", "Dispatcher Servlet" }, 2),
			new Question(5L, "Which is Spring's front Controller Implementation?", new String[] { "Bean Factory", "Class Path Application Context", "Application Context", "Dispatcher Servlet" }, 4)
	};
	
	public static Question hibernateQuestionAndAnswerOption[] ={			
			new Question(1L, "What is the full form of ORM?", new String[] { "Object Random Memory", "Object Relational Mismatch", "Object Relational Mapping", "Object Random Mapping" }, 3),
			new Question(2L, "In Hibernate, based on directionality, what could be the mappings?", new String[] { "uni-directional & bi-directional", "one-to-many & many-to-one", "inheritance mapping", "north & south mapping" }, 1),
			new Question(3L, "In an Hibernate application, which file would have datasource details?", new String[] { "hibernate mapping file", "configuration file", "Model/Entity class", "HibernateUtil class" }, 2),
			new Question(4L, "What is the full form of HQL?", new String[] { "High-level Query Language", "Hidden Query Language", "Hibernate Query Language", "Hibernate Quadratic Language" }, 3),
			new Question(5L, "In an Hibernate application, concurrency can be controlled by setting?", new String[] { "concurrency level", "one-to-one mapping", "many-to-one-bi-directional mapping", "isolation levels" }, 4)
	};
}
