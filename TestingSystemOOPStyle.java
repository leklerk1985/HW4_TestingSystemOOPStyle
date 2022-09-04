import java.util.Scanner;

public class TestingSystemOOPStyle {
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

        Answer[] answers = new Answer[11];
        answers[0] = new Answer(questions[0], "Сатурн", 1);
        answers[1] = new Answer(questions[0], "Венера", 2);
        answers[2] = new Answer(questions[0], "Юпитер", 3);
        answers[3] = new Answer(questions[0], "Марс", 4);
        answers[4] = new Answer(questions[0], "Нептун", 5);
        answers[5] = new Answer(questions[1], "Млечный путь", 1);
        answers[6] = new Answer(questions[1], "Галактика Андромеды", 2);
        answers[7] = new Answer(questions[1], "M 110", 3);
        answers[8] = new Answer(questions[2], "Пояс Койпера", 1);
        answers[9] = new Answer(questions[2], "Пояс астероидов", 2);
        answers[10] = new Answer(questions[2], "Пояс Ориона", 3);

        for (Question question: questions) {

            question.print();

            Answer[] ownAnswers = question.getOwnAnswers(answers);
            for (Answer ownAnswer: ownAnswers) {
                ownAnswer.print();
            }

            System.out.println();


            answerGiven = Integer.parseInt(scanner.next());
            if (answerGiven == question.getRightAnswer()) {
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

    public Answer[] getOwnAnswers(Answer[] answers) {

        int[] ownIndexes = new int[answers.length];
        int currentIndex = 0;

        for (int i = 0; i < ownIndexes.length; i++) {
            if (this == answers[i].getQuestion()) {
                ownIndexes[currentIndex] = i;
                currentIndex++;
            }
        }

        Answer[] ownAnswers = new Answer[currentIndex];
        for (int j = 0; j < currentIndex; j++) {
            ownAnswers[j] = answers[ownIndexes[j]];
        }

        return ownAnswers;
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