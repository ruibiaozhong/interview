package com.leihou.interview.constant;

public class MqConst {

    public static class exchange {

        public static String TOPIC_USER_EXCHANGE ="topicUserExchange";


    }

    public static class topic {

        public static class routingKey {


            public static final String USER_ADD = "topic.user.add";

            public static final String USER_UPDATE = "topic.user.update";
        }





    }


    public static class queue {

        public static final String USER_QUEUE_ADD = "userQueueAdd";

        public static final String USER_QUEUE_UPDATE = "userQueueUpdate";



    }


}
