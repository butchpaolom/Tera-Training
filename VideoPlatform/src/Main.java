
public class Main {
	public static void main(String args[]) {
        Video video = new Video();
        video.setFileName("2020-9-4.mp4");
        video.setTitle("Hello mundo");
        video.setUser(new User("adik@gmail.com"));

        VideoProcessor processor = new VideoProcessor(
            new ThreadedVideoEncoder(),
            new SQLVideoDatabase(),
            new EmailService()
        );
        processor.process(video);
	}
}
