package bt.runtime;

import bt.service.NetworkUtil;

import java.net.InetAddress;
import java.time.Duration;

/**
 * Provides runtime configuration parameters.
 *
 * @since 1.0
 */
public class Config {

    private InetAddress acceptorAddress;
    private int acceptorPort;
    private Duration peerDiscoveryInterval;
    private Duration peerHandshakeTimeout;
    private Duration peerConnectionRetryInterval;
    private int peerConnectionRetryCount;
    private Duration peerConnectionTimeout;
    private Duration peerConnectionInactivityThreshold;
    private Duration trackerQueryInterval;
    private int maxPeerConnections;
    private int maxPeerConnectionsPerTorrent;
    private int transferBlockSize;
    private int maxTransferBlockSize;
    private int maxIOQueueSize;
    private Duration shutdownHookTimeout;
    private int numOfHashingThreads;
    private int maxConcurrentlyActivePeerConnectionsPerTorrent;
    private Duration maxPieceReceivingTime;
    private long maxMessageProcessingInterval;

    /**
     * Create a config with default parameters.
     *
     * @since 1.0
     */
    public Config() {
        this.acceptorAddress = NetworkUtil.getInetAddressFromNetworkInterfaces();
        this.acceptorPort = 6891;
        this.peerDiscoveryInterval = Duration.ofSeconds(5);
        this.peerConnectionRetryInterval = Duration.ofMinutes(5);
        this.peerConnectionRetryCount = 3;
        this.peerConnectionTimeout = Duration.ofSeconds(30);
        this.peerHandshakeTimeout = Duration.ofSeconds(3);
        this.peerConnectionInactivityThreshold = Duration.ofMinutes(3);
        this.trackerQueryInterval = Duration.ofMinutes(5);
        this.maxPeerConnections = 500;
        this.maxPeerConnectionsPerTorrent = maxPeerConnections; // assume single torrent per runtime by default; change this to (maxActive * 2) maybe?
        this.transferBlockSize = 2 << 13; // 8 KB
        this.maxTransferBlockSize = 2 << 16; // 128 KB
        this.maxIOQueueSize = 1000;
        this.shutdownHookTimeout = Duration.ofSeconds(5);
        this.numOfHashingThreads = 1; // do not parallelize by default
        this.maxConcurrentlyActivePeerConnectionsPerTorrent = 20;
        this.maxPieceReceivingTime = Duration.ofSeconds(30);
        this.maxMessageProcessingInterval = 100;
    }

    /**
     * Clone the provided config.
     *
     * @param config Config to take parameters from.
     * @since 1.0
     */
    public Config(Config config) {
        this.acceptorAddress = config.getAcceptorAddress();
        this.acceptorPort = config.getAcceptorPort();
        this.peerDiscoveryInterval = config.getPeerDiscoveryInterval();
        this.peerConnectionRetryInterval = config.getPeerConnectionRetryInterval();
        this.peerConnectionRetryCount = config.getPeerConnectionRetryCount();
        this.peerConnectionTimeout = config.getPeerConnectionTimeout();
        this.peerHandshakeTimeout = config.getPeerHandshakeTimeout();
        this.peerConnectionInactivityThreshold = config.getPeerConnectionInactivityThreshold();
        this.trackerQueryInterval = config.getTrackerQueryInterval();
        this.maxPeerConnections = config.getMaxPeerConnections();
        this.maxPeerConnectionsPerTorrent = config.getMaxPeerConnectionsPerTorrent();
        this.transferBlockSize = config.getTransferBlockSize();
        this.maxTransferBlockSize = config.getMaxTransferBlockSize();
        this.maxIOQueueSize = config.getMaxIOQueueSize();
        this.shutdownHookTimeout = config.getShutdownHookTimeout();
        this.numOfHashingThreads = config.getNumOfHashingThreads();
        this.maxConcurrentlyActivePeerConnectionsPerTorrent = config.getMaxConcurrentlyActivePeerConnectionsPerTorrent();
        this.maxPieceReceivingTime = config.getMaxPieceReceivingTime();
        this.maxMessageProcessingInterval = config.getMaxMessageProcessingInterval();
    }

    /**
     * @param acceptorAddress Local link that will be used by the incoming connection acceptor.
     * @since 1.0
     */
    public void setAcceptorAddress(InetAddress acceptorAddress) {
        this.acceptorAddress = acceptorAddress;
    }

    /**
     * @since 1.0
     */
    public InetAddress getAcceptorAddress() {
        return acceptorAddress;
    }

    /**
     * @param acceptorPort Local port that will be used by the incoming connection acceptor.
     * @since 1.0
     */
    public void setAcceptorPort(int acceptorPort) {
        this.acceptorPort = acceptorPort;
    }

    /**
     * @since 1.0
     */
    public int getAcceptorPort() {
        return acceptorPort;
    }

    /**
     * @param peerDiscoveryInterval Interval at which peer sources should be queried for new peers.
     * @since 1.0
     */
    public void setPeerDiscoveryInterval(Duration peerDiscoveryInterval) {
        this.peerDiscoveryInterval = peerDiscoveryInterval;
    }

    /**
     * @since 1.0
     */
    public Duration getPeerDiscoveryInterval() {
        return peerDiscoveryInterval;
    }

    /**
     * @param peerHandshakeTimeout  Time to wait for a peer's handshake.
     * @since 1.0
     */
    public void setPeerHandshakeTimeout(Duration peerHandshakeTimeout) {
        this.peerHandshakeTimeout = peerHandshakeTimeout;
    }

    /**
     * @since 1.0
     */
    public Duration getPeerHandshakeTimeout() {
        return peerHandshakeTimeout;
    }

    /**
     * @param peerConnectionRetryInterval Interval at which attempts to connect to a peer will be performed
     * @since 1.0
     */
    public void setPeerConnectionRetryInterval(Duration peerConnectionRetryInterval) {
        this.peerConnectionRetryInterval = peerConnectionRetryInterval;
    }

    /**
     * @since 1.0
     */
    public Duration getPeerConnectionRetryInterval() {
        return peerConnectionRetryInterval;
    }

    /**
     * @param peerConnectionRetryCount Max number of attempts to connect to a peer
     * @since 1.0
     */
    public void setPeerConnectionRetryCount(int peerConnectionRetryCount) {
        this.peerConnectionRetryCount = peerConnectionRetryCount;
    }

    /**
     * @since 1.0
     */
    public int getPeerConnectionRetryCount() {
        return peerConnectionRetryCount;
    }

    /**
     * @param peerConnectionTimeout Amount of time to wait for establishing of a peer connection
     * @since 1.0
     */
    public void setPeerConnectionTimeout(Duration peerConnectionTimeout) {
        this.peerConnectionTimeout = peerConnectionTimeout;
    }

    /**
     * @since 1.0
     */
    public Duration getPeerConnectionTimeout() {
        return peerConnectionTimeout;
    }

    /**
     * @param peerConnectionInactivityThreshold Amount of time after which an inactive peer connection will be dropped
     * @since 1.0
     */
    public void setPeerConnectionInactivityThreshold(Duration peerConnectionInactivityThreshold) {
        this.peerConnectionInactivityThreshold = peerConnectionInactivityThreshold;
    }

    /**
     * @since 1.0
     */
    public Duration getPeerConnectionInactivityThreshold() {
        return peerConnectionInactivityThreshold;
    }

    /**
     * @param trackerQueryInterval Interval at which trackers will be queried for peers.
     * @since 1.0
     */
    public void setTrackerQueryInterval(Duration trackerQueryInterval) {
        this.trackerQueryInterval = trackerQueryInterval;
    }

    /**
     * @since 1.0
     */
    public Duration getTrackerQueryInterval() {
        return trackerQueryInterval;
    }

    /**
     * @param maxPeerConnections Maximum amount of established peer connections
     * @since 1.0
     */
    public void setMaxPeerConnections(int maxPeerConnections) {
        this.maxPeerConnections = maxPeerConnections;
    }

    /**
     * @since 1.0
     */
    public int getMaxPeerConnections() {
        return maxPeerConnections;
    }

    /**
     * @param maxPeerConnectionsPerTorrent Maximum number of established peer connections
     *                                     within a torrent processing session.
     *                                     Affects performance (too few or too many is bad).
     * @since 1.0
     */
    public void setMaxPeerConnectionsPerTorrent(int maxPeerConnectionsPerTorrent) {
        this.maxPeerConnectionsPerTorrent = maxPeerConnectionsPerTorrent;
    }

    /**
     * @since 1.0
     */
    public int getMaxPeerConnectionsPerTorrent() {
        return maxPeerConnectionsPerTorrent;
    }

    /**
     * @param transferBlockSize Network transfer block size
     * @since 1.0
     */
    public void setTransferBlockSize(int transferBlockSize) {
        this.transferBlockSize = transferBlockSize;
    }

    /**
     * @since 1.0
     */
    public int getTransferBlockSize() {
        return transferBlockSize;
    }

    /**
     * @param maxTransferBlockSize Maximum supported transfer block size.
     * @since 1.0
     */
    public void setMaxTransferBlockSize(int maxTransferBlockSize) {
        this.maxTransferBlockSize = maxTransferBlockSize;
    }

    /**
     * @since 1.0
     */
    public int getMaxTransferBlockSize() {
        return maxTransferBlockSize;
    }

    /**
     * @param maxIOQueueSize Maximum depth of I/O operations queue (read/write blocks).
     */
    public void setMaxIOQueueSize(int maxIOQueueSize) {
        this.maxIOQueueSize = maxIOQueueSize;
    }

    /**
     * @since 1.0
     */
    public int getMaxIOQueueSize() {
        return maxIOQueueSize;
    }

    /**
     * @param shutdownHookTimeout Amount of time to wait for a shutdown hook to execute before killing it
     * @since 1.0
     */
    public void setShutdownHookTimeout(Duration shutdownHookTimeout) {
        this.shutdownHookTimeout = shutdownHookTimeout;
    }

    /**
     * @since 1.0
     */
    public Duration getShutdownHookTimeout() {
        return shutdownHookTimeout;
    }

    /**
     * @param numOfHashingThreads Set this value to 2 or greater,
     *                            if verification of the torrent data should be parallelized
     * @since 1.1
     */
    public void setNumOfHashingThreads(int numOfHashingThreads) {
        this.numOfHashingThreads = numOfHashingThreads;
    }

    /**
     * @since 1.1
     */
    public int getNumOfHashingThreads() {
        return numOfHashingThreads;
    }

    /**
     * Maximum number of peer connections that are allowed to request and receive pieces.
     * Note that this value implicitly affects when the torrent processing session enters
     * the so-called "endgame" mode. By default it's assumed that the endgame mode should
     * be activated when the number of remaining (incomplete) pieces is smaller than the
     * number of pending requests, which in its' turn is no greater than this value.
     *
     * E.g. if the limit for concurrently active connections is 20, and there are in fact 20
     * peers that we are downloading from at the moment, then the endgame will begin
     * as soon as there are 20 pieces left to download. At the same time if there are only 15
     * active connections, than the endgame will begin when there are 15 pieces left.
     * Thus this value affects only the lower bound on the number of pieces to be left
     * to trigger the beginning of an endgame.
     *
     * @param maxConcurrentlyActivePeerConnectionsPerTorrent Maximum number of peer connections
     *                                                       that are allowed to request and receive pieces.
     * @since 1.1
     */
    public void setMaxConcurrentlyActivePeerConnectionsPerTorrent(int maxConcurrentlyActivePeerConnectionsPerTorrent) {
        this.maxConcurrentlyActivePeerConnectionsPerTorrent = maxConcurrentlyActivePeerConnectionsPerTorrent;
    }

    /**
     * @since 1.1
     */
    public int getMaxConcurrentlyActivePeerConnectionsPerTorrent() {
        return maxConcurrentlyActivePeerConnectionsPerTorrent;
    }

    /**
     * @param maxPieceReceivingTime Limit on the amount of time it takes to receive all blocks in a piece
     *                              from a peer until this peer is considered timeouted and banned for a short
     *                              amount of time (with the piece being unassigned from this peer).
     * @since 1.1
     */
    public void setMaxPieceReceivingTime(Duration maxPieceReceivingTime) {
        this.maxPieceReceivingTime = maxPieceReceivingTime;
    }

    /**
     * @since 1.1
     */
    public Duration getMaxPieceReceivingTime() {
        return maxPieceReceivingTime;
    }

    /**
     * This option is related to the adaptive message processing interval feature in the message dispatcher.
     * The lower this value the higher the ingoing/outgoing message processing rate but also higher the CPU load.
     * Reasonable value (in 100..1000 ms range) greatly reduces the CPU load when there is little network activity
     * without compromising the overall message exchange rates.
     *
     * @see bt.net.MessageDispatcher
     * @param maxMessageProcessingInterval Maximum time to sleep between message processing loop iterations, in millis.
     * @since 1.1
     */
    public void setMaxMessageProcessingInterval(long maxMessageProcessingInterval) {
        this.maxMessageProcessingInterval = maxMessageProcessingInterval;
    }

    /**
     * @since 1.1
     */
    public long getMaxMessageProcessingInterval() {
        return maxMessageProcessingInterval;
    }
}