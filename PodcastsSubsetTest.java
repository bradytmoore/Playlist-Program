import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PodcastsSubsetTest {
    @Test
    public void testPlay1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        Episode e = evaluator.play();
        assertEquals("The Summit", e.getTitle());
    }

    @Test
    public void testPlay3() {
        assertThrows(InvalidEpisodeException.class, () -> {
            Podcasts evaluator = new Podcasts();
            Episode e = evaluator.play();
        });
    }

    @Test
    public void testPlayNext2() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        assertEquals("The Death Zone\nThe Summit\n", evaluator.toString());
    }

    @Test
    public void testPlayLast1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playLast(new Episode("The Summit", "Mike Corey", 46));
        assertEquals("The Summit\n", evaluator.toString());
    }

    @Test
    public void testPlayEpisode1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playEpisode(1, new Episode("The Summit", "Mike Corey", 46));
        assertEquals("The Summit\n", evaluator.toString());
    }
    @Test
    public void testPlayEpisode3() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Savage Mountain", "Mike Corey", 52));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playEpisode(3, new Episode("The Summit", "Mike Corey", 46));
        assertEquals("The Death Zone\nThe Savage Mountain\nThe Summit\n", evaluator.toString());
    }

    @Test
    public void testPlayEpisode6() {
        assertThrows(InvalidEpisodeException.class, () -> {
            Podcasts evaluator = new Podcasts();
            evaluator.playNext(new Episode("The Savage Mountain", "Mike Corey", 52));
            evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
            evaluator.playEpisode(4, new Episode("The Summit", "Mike Corey", 46));

        });
    }

    @Test
    public void testPlayNextAndLast1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playLast(new Episode("The Death Zone", "Mike Corey", 45));
        assertEquals("The Summit\nThe Death Zone\n", evaluator.toString());
    }

    @Test
    public void testPlayNextAndLast4() {
        Podcasts evaluator = new Podcasts();
        evaluator.playLast(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playLast(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playNext(new Episode("The Savage Mountain", "Mike Corey", 52));
        evaluator.playNext(new Episode("Climbing High Peaks", "Mike Corey", 45));
        assertEquals("Climbing High Peaks\nThe Savage Mountain\nThe Summit\nThe Death Zone\n", evaluator.toString());
    }

   @Test
    public void testPlayEpisodeNextAndLast2() {
        Podcasts evaluator = new Podcasts();
        evaluator.playLast(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playNext(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.playEpisode(2, new Episode("The Savage Mountain", "Mike Corey", 52));
        evaluator.playNext(new Episode("Climbing High Peaks", "Mike Corey", 45));
        assertEquals("Climbing High Peaks\nThe Death Zone\nThe Savage Mountain\nThe Summit\n", evaluator.toString());
    }

    @Test
    public void testDeleteNext1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.deleteNext();
        assertEquals("", evaluator.toString());
    }

     @Test
    public void testDeleteNext3() {
        assertThrows(InvalidEpisodeException.class, () -> {
            Podcasts evaluator = new Podcasts();
            evaluator.deleteNext();

        });
    }

    @Test
    public void testDeleteLast1() {
        Podcasts evaluator = new Podcasts();
        evaluator.playNext(new Episode("The Summit", "Mike Corey", 46));
        evaluator.deleteLast();
        assertEquals("", evaluator.toString());
    }

    @Test
    public void testDeleteEpisode2() {
        Podcasts evaluator = new Podcasts();
        evaluator.playLast(new Episode("The Summit", "Mike Corey", 46));
        evaluator.playLast(new Episode("The Death Zone", "Mike Corey", 45));
        evaluator.deleteEpisode("The Summit");
        assertEquals("The Death Zone\n", evaluator.toString());
    }

    @Test
    public void testDeleteEpisode4() {
        assertThrows(InvalidEpisodeException.class, () -> {
            Podcasts evaluator = new Podcasts();
            evaluator.deleteEpisode("The Summit");

        });
    }

}