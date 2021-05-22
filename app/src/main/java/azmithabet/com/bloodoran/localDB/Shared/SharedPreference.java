package azmithabet.com.bloodoran.localDB.Shared;


public class SharedPreference {

//     private static Context context;
//     public SharedPreference(Context context){
//         this.context=context;
//     }
//
//    public static void setUser(User user, Context context){
//        @SuppressLint("WrongConstant")
//        SharedPreferences.Editor editor =context.
//                getSharedPreferences(USERS_NODE, MODE_PRIVATE).edit();
//        editor.putString("userName", user.getUserName() );
//        editor.putString("phoneNumber", user.getPhoneNumber() );
//        editor.putString("email", user.getEmail() );
//            editor.putString("address", user.getAddress() );
//        editor.putString("picUrl", user.getPicUrl() );
//        editor.apply();
//    }
//
//    public static User getUser(Context context){
//        @SuppressLint("WrongConstant")
//        SharedPreferences prefs =
//                context.getSharedPreferences(USERS_NODE, MODE_PRIVATE);
//         String userName=prefs.getString("userName", "");
//        String phoneNumber=prefs.getString("phoneNumber", "");
//        String email=prefs.getString("email", "");
//         String address=prefs.getString("address", "");
//        String picUrl=prefs.getString("picUrl", "");
//         return new User(userName,phoneNumber,email,address,"",picUrl);
//    }
//
//    public static void  logoutUser(Context context){
//        @SuppressLint("CommitPrefEdits")
//        SharedPreferences.Editor editor =context.getSharedPreferences(SELLER_NODE, MODE_PRIVATE).edit();
//        editor.clear();
//        editor.apply();
//
//    }
//
//    public static boolean isUserLogin(Context context){
//        SharedPreferences prefs =
//                context.getSharedPreferences(USERS_NODE, MODE_PRIVATE);
//        String userName=prefs.getString("userName", "");
//        return !userName.isEmpty();
//    }



}
