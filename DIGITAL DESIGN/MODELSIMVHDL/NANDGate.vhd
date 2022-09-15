library ieee;
use ieee.std_logic_1164.all;

entity NAND_ent is
  port ( x : in std_logic;
  y : in std_logic;
  f : out std_logic);
end NAND_ent;

architecture NAND_arch of NAND_ent is
begin
  process (x,y)
  begin
    if ((x = '1') and (y = '1')) then
      f <= '0';
    else
      f <= '1';
    end if;
  end process;
end NAND_arch;
