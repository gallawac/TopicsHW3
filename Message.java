//Colin Gallaway and Andrew Chough

import java.math.BigInteger;
import java.io.Serializable;
public class Message implements Serializable
{
	private int blockVersion;
	private String prevBlock; //256-bit hash
	private String merkleRoot; //256-bit hash
	private long timeStamp; //Unix Time in seconds
	private BigInteger target;
	private BigInteger nonce; //32-bit number
	
	private String blockHash; //sha-256 hash of the block
	
	public Message(Block block){
		BlockHeader header = block.getBlockHeader();
		
		blockVersion = header.getBlockVersion();
		prevBlock = (header.getPrevBlock()).toString();
		merkleRoot = (header.getMerkleRoot()).toString();
		timeStamp = header.getTimeStamp();
		target = header.getTarget();
		nonce = header.getNonce();
		
		blockHash = block.getHashValue();
	}
	
	
	public int getBlockVersion(){
		return blockVersion;
	}
	
	public String getPrevBlock(){
		return prevBlock;
	}
	
	public String getMerkleRoot(){
		return merkleRoot;
	}
	
	public long getTimeStamp(){
		return timeStamp;
	}
	
	public BigInteger getTarget(){
		return target;
	}
	
	public BigInteger getNonce(){
		return nonce;
	}
	
	public String getBlockHash(){
		return blockHash;
	}
}