package talkie;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Generates reply based on random selection from the initial list of replies
 *
 * @author Anna Khasanova
 */
public class DefaultReplyGenerator implements ReplyGenerator {
    
    private List<String> answers = new ArrayList<String>();
    
    public DefaultReplyGenerator() {
    	//answers.add("Конечно! Что за вопрос!");
    	answers.add("Of course you can!");
        //answers.add("Хмм... ну попробуй....");
    	answers.add("Hmm.. You can try..");
        //answers.add("Я бы не советовал, но решать тебе.");
    	answers.add("It is not good idea but you can try");
        //answers.add("Можно, но ооочень осторожно");
    	answers.add("You can but be careful");
        //answers.add("И думать забудь!");
    	answers.add("No-no-no!!");
        //answers.add("Ваш вопрос уже отправлен в ФСБ. Ждите, за вами выехали.");
    	answers.add("I said it to FBI. Wait");
        }

    
    @Override
    public String generate() {
        Random random = new Random();
        int selected = random.nextInt(answers.size());
        return answers.get(selected);
    }
}
