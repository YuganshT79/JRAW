package net.dean.jraw.models;

import net.dean.jraw.models.attr.Created;
import org.codehaus.jackson.JsonNode;

public class LiveThread extends RedditObject implements Created {
    /**
     * Instantiates a new LiveEvent
     *
     * @param dataNode The node to parse data from
     */
    public LiveThread(JsonNode dataNode) {
        super(dataNode);
    }

    /**
     * Gets the thread's description
     * @return The thread's description
     */
    @JsonInteraction
    public RenderStringPair getDescription() {
        return data("description", RenderStringPair.class);
    }

    /**
     * Gets the title of the thread
     * @return The title of the thread
     */
    @JsonInteraction
    public String getTitle() {
        return data("title");
    }

    /**
     * Returns the WebSocket URL (wss://) to the thread
     * @return The WebSocket URL
     */
    @JsonInteraction(nullable = true)
    public String getWebsocketUrl() {
        return data("websocket_url");
    }

    /**
     * Checks if this live event is still active
     * @return If this event is still active
     */
    @JsonInteraction
    public Boolean isActive() {
        return data("state").equals("live"); // 'complete' if not active
    }

    /**
     * Gets the amount of people watching this thread
     * @return The amount of viewers
     */
    @JsonInteraction
    public Integer getViewerCount() {
        return data("viewer_count", Integer.class);
    }

    /**
     * Checks if the viewer count is "fuzzed". This most often happens when there are less than 100 viewers.
     * @return If the viewer count is fuzzed
     */
    @JsonInteraction
    public Boolean isViewerCountFuzzed() {
        return data("viewer_count_fuzzed", Boolean.class);
    }

    /**
     * This LiveEvent's ID. Do not confuse this with {@link Thing#getId()}.
     * @return The thread's ID
     */
    @JsonInteraction
    public String getId() {
        return data("id");
    }

    /**
     * Gets the data under the "resources" header displayed on the right side of the Reddit Live page.
     * @return The resources
     */
    @JsonInteraction
    public String getResources() {
        return data("resources");
    }

    @Override
    public ThingType getType() {
        return ThingType.LIVE_THREAD;
    }
}
