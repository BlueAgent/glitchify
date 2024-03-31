package glitchify.core.api;

@SuppressWarnings("WeakerAccess")
public final class CoreUtils {
    private CoreUtils() {
    }

    @SuppressWarnings("unchecked")
    public static <T> T loadClass(String className) {
        try {
            return (T) Class.forName(className).newInstance();
        } catch (ClassCastException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
