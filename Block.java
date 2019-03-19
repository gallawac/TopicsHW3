//Colin Gallaway and Andrew Chough
import java.util.concurrent.TimeUnit;
import java.math.BigInteger;

public class Block
{
	static final String MAX_HASH= "FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF";
	private BlockHeader prevBlockHeader;
	private BlockHeader newBlockHeader;
	
	public Block(String targ){
		BigInteger target = new BigInteger(targ, 16);
		//create a previous block
		BlockHeader prevBlockHeader = new BlockHeader();
		
		//nonce up to 4,294,967,295 (32-bit max value)
		BigInteger nonce = BigInteger.ZERO;
		BigInteger maxNonce = new BigInteger("1", 2);
		maxNonce = maxNonce.shiftLeft(32);
		//System.out.println(String.format("%064X",maxNonce));
		while (true){
			if(nonce.compareTo(maxNonce) >= 0){
				System.out.println("Failed to find hash under target value before max nonce reached.");
				break;
			}
			if(solvedPuzzle(nonce, prevBlockHeader, target) == true){	
				System.out.println("Puzzle Solved!");
				break;
			}
			nonce = nonce.add(BigInteger.ONE);
		}
	}
	
	public Block(BlockHeader prevBlockHeader, String targ){
		BigInteger target = new BigInteger(targ, 16);
		BigInteger nonce = BigInteger.ZERO;
		BigInteger maxNonce = new BigInteger("1", 2);
		maxNonce = maxNonce.shiftLeft(32);
		//System.out.println(String.format("%064X",maxNonce));
		while (true){
			if(nonce.compareTo(maxNonce) >= 0){
				System.out.println("Failed to find hash under target value before max nonce reached.");
				break;
			}
			if(solvedPuzzle(nonce, prevBlockHeader, target) == true){	
				System.out.println("Puzzle Solved!");
				break;
			}
			nonce = nonce.add(BigInteger.ONE);
		}
	}
	
	private boolean solvedPuzzle(BigInteger nonce, BlockHeader header, BigInteger target){
		Hash prevHash = new Hash(header.toString());
		BlockHeader attempt = new BlockHeader(2, prevHash, newMerkleRoot(), target, nonce);
		Hash hash = new Hash(attempt.toString());
		if(hash.toBigInteger().compareTo(target) == -1){
				newBlockHeader = attempt;
				return true;
			}
		return false;
	}
	
	//for future use
	private Hash newMerkleRoot(){
		//temporary return:
		return new Hash();
	}
	
	//for future use
	private String nextDifficulty(){
		//temporary return
		return (new Hash()).toString();
	}
	
	public String getHashValue(){
		return ( new Hash(newBlockHeader.toString()) ).toString();
	}
}