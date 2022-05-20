public class Codec {
    HashMap<String,String> a=new HashMap<String,String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        char[] b={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        StringBuilder shortUrl =new StringBuilder();
        String d;
        shortUrl.append(longUrl.substring(0,8));
        for(int i=8;i<longUrl.length();i++){
            int c=longUrl.charAt(i)-'a';
            if(c>=0 && c<=25){
                c=(c*24)%26;
                shortUrl.append(b[c]);
            }
            else{
                shortUrl.append(longUrl.charAt(i));
            }
        }
        d=shortUrl.toString();
        a.put(d,longUrl);
        return d;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String b=a.get(shortUrl);
        return b;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));