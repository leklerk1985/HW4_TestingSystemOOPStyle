import java.util.Scanner;

public class HW4_TestingSystemOOPStyle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int rightAnswersGiven = 0;
        int wrongAnswersGiven;
        int answerGiven;

        Question[] questions = new Question[3];
        questions[0] = new Question("Назовите самую большую планету Солнечной системы.", 3);
        questions[1] = new Question("Как называется галактика, в которой находится Солнечная система?", 1);
        questions[2] = new Question("Назовите область Солнечной системы, находящуюся между планетами земной группы (Меркурий, Венера, Земля, Марс) " +
                "и газовыми гигантами (Юпитер, Сатурн, Уран и Нептун).", 2);

        Answer[][] answers = {
                {new Answer(questions[0], "Сатурн", 1),
                new Answer(questions[0], "Венера", 2),
                new Answer(questions[0], "Юпитер", 3),
                new Answer(questions[0], "Марс", 4),
                new Answer(questions[0], "Нептун", 5)},

                {new Answer(questions[1], "Млечный путь", 1),
                new Answer(questions[1], "Галактика Андромеды", 2),
                new Answer(questions[1], "M 110", 3)},

                {new Answer(questions[2], "Пояс Койпера", 1),
                new Answer(questions[2], "Пояс астероидов", 2),
                new Answer(questions[2], "Пояс Ориона", 3)}};

        for (int i = 0; i < questions.length; i++) {

            questions[i].print();
            for (int j = 0; j < answers[i].length; j++) {
                answers[i][j].print();
            }
            System.out.println();


            answerGiven = Integer.parseInt(scanner.next());
            if (answerGiven == questions[i].getRightAnswer()) {
                rightAnswersGiven++;
                System.out.println("Правильно");
            } else {
                System.out.println("Неправильно");
            }
            System.out.println();

        }

        wrongAnswersGiven = questions.length - rightAnswersGiven;
        System.out.println("Результат: правильно " + rightAnswersGiven + ", неправильно " + wrongAnswersGiven + ".");

    }
}

class Question {
    private String text;
    private int rightAnswer;

    Question(String text, int rightAnswer) {
        this.text = text;
        this.rightAnswer = rightAnswer;
    }

    public int getRightAnswer() {
        return rightAnswer;
    }

    public void print() {
        System.out.println(text);
    }
}

class Answer {
    private Question question;
    private String text;
    private int number;

    Answer(Question question, String text, int number) {
        this.question = question;
        this.text = text;
        this.number = number;
    }

    public Question getQuestion() {
        return question;
    }

    public void print() {
        System.out.println(number + ". " + text);
    }
}