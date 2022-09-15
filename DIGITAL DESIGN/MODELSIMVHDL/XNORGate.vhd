library ieee;
use ieee.std_logic_1164.all;

entity XNOR_ent is
  port ( x : in std_logic;
  y : in std_logic;
  f : out std_logic);
end XNOR_ent;

architecture XNOR_arch of XNOR_ent is
begin
  process (x, y)
  begin
    if (x = y) then
      f <= '1';
    else
      f <= '0';
    end if;
  end process;
end XNOR_arch;

