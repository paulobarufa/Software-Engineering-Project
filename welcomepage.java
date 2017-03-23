	public void startQuiz( Stage primaryStage, String[] allQuestions, String[][] allAnswers, int[] stats) {
		Group root = new Group();
		Scene scene = new Scene(root, 1500,900);
		Random rand = new Random(System.currentTimeMillis());
		
		int red = 0;
		int blue = 0;
		int green = 0;	
		int rot = 0;
		
		
		for (int j=0; j<500; j++){
			int x = rand.nextInt((int) scene.getWidth());
			int y = rand.nextInt(200);
			red = rand.nextInt(100);
			green = rand.nextInt(200);
			blue = rand.nextInt(200);	
			rot = rand.nextInt(360);
			
			Text text = new Text(x,y, "quiz");
			Font serifSmall = new Font ("Serif", 18);
			text.setFont(serifSmall);
			text.setFill(Color.rgb(red, blue, green, .4));
			text.setRotate(rot);
			root.getChildren().add(text);
			
		}
		

		Text text2 = new Text(570,120,"Quiz");
		text2.setFont(Font.font("Serif", FontWeight.BOLD, 80));		
		root.getChildren().add(text2);

		FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 0, 10);
    	rootNode.setAlignment(Pos.CENTER);
    	rootNode.setColumnHalignment(HPos.CENTER);
    	rootNode.setPadding(new Insets(300, 0, 0, 600));

		//Scene scene = new Scene(rootNode, 1500,900);

		primaryStage.setScene(scene);

		//Display questions and answers
		Label welcome = new Label("Welcome to the Quiz!");
	

    	Button start = new Button("Start");
    	start.setPrefWidth(60);

    	start.setOnAction( new EventHandler<ActionEvent>() {
    		@Override
    			public void handle(ActionEvent ae) {
    				showQuestion(0, primaryStage, allQuestions, allAnswers, stats);
    			}
    	});

    	rootNode.getChildren().addAll(welcome, start);
    	root.getChildren().add(rootNode);
    	primaryStage.setScene(scene);
    	primaryStage.show();
	}
  
  //replace initial call of showQuestion with this
  startQuiz(primaryStage, allQuestions, allAnswers, stats);
